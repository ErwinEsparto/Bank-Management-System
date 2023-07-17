package com.school.bank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Erwin Esparto
 */
public class Depositpage extends JFrame implements ActionListener {
    private final JLabel lblInfo, lblAmount1, lblAmount2, lblResult, lblBalance;
    private final JTextField txtfldAmount1, txtfldAmount2;
    private final JButton btnDeposit, btnBack;
    private BankServices service = new BankServices();
    private BankAccount account;
    
    Depositpage(BankAccount account){
        this.account = account;
        setTitle("Deposit Cash");
        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        lblInfo = new JLabel("Provide the details to deposit cash: ");
        lblInfo.setBounds(70, 110, 350, 30);
        lblInfo.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        
        lblAmount1 = new JLabel("Amount: ");
        lblAmount1.setBounds(100, 150, 110, 30);
        lblAmount1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        txtfldAmount1 = new JTextField();
        txtfldAmount1.setBounds(230, 150, 150, 30);
        txtfldAmount1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        lblAmount2 = new JLabel("Confirm Amount: ");
        lblAmount2.setBounds(100, 190, 130, 30);
        lblAmount2.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        txtfldAmount2 = new JTextField();
        txtfldAmount2.setBounds(230, 190, 150, 30);
        txtfldAmount2.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        btnDeposit = new JButton("Deposit");
        btnDeposit.setBounds(230, 230, 150, 30);
        btnDeposit.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        btnDeposit.addActionListener(this);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(100, 230, 120, 30);
        btnBack.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        btnBack.addActionListener(this);
        
        lblResult = new JLabel();
        lblResult.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        lblBalance = new JLabel();
        lblBalance.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        add(lblInfo);
        add(lblAmount1);
        add(txtfldAmount1);
        add(lblAmount2);
        add(txtfldAmount2);
        add(btnDeposit);
        add(btnBack);
        add(lblResult);
        add(lblBalance);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btnDeposit){
            double amount1 = Double.parseDouble(txtfldAmount1.getText());
            double amount2 = Double.parseDouble(txtfldAmount2.getText());
            
            if(amount1 == amount2){
                double newCash = account.getCash() + amount2;
                account.setCash(newCash);
                //insert database method here
                
                lblResult.setBounds(100, 270, 300, 30);
                lblResult.setForeground(Color.black);
                lblResult.setText("   Successful Deposit.");
                lblResult.setBorder( new MatteBorder(0, 1, 0, 0, Color.black));
                
                lblBalance.setBounds(100, 300, 300, 30);
                lblBalance.setText("   New Balance: PHP " + account.getCash());
                lblBalance.setBorder( new MatteBorder(0, 1, 0, 0, Color.black));
            }
            else{
                lblResult.setBounds(150, 270, 300, 30);
                lblResult.setForeground(Color.red);
                lblResult.setBorder( new MatteBorder(0, 0, 0, 0, Color.black));
                lblResult.setText("Amounts are not the same.");
                lblBalance.setBounds(0, 0, 0, 0);
            }
        }
        else if (e.getSource() == btnBack){
            dispose();
            Menupage menu = new Menupage();
            menu.setVisible(true);
        }
    }
}