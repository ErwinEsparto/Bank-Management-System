package com.school.bank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Erwin Esparto
 */
public class Withdrawpage extends JFrame implements ActionListener {
    private final JLabel lblInfo, lblAmount1, lblAmount2, lblResult, lblBalance;
    private final JTextField txtfldAmount1, txtfldAmount2;
    private final JButton btnWithdraw, btnBack;
    private BankServices service = new BankServices();
    private BankAccount account;
    
    Withdrawpage(BankAccount account){
        this.account = account;
        setTitle("Withdraw Cash");
        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        lblInfo = new JLabel("Provide the details for withdrawal:");
        lblInfo.setBounds(80, 110, 350, 30);
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
        
        btnWithdraw = new JButton("Withdraw");
        btnWithdraw.setBounds(230, 230, 150, 30);
        btnWithdraw.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        btnWithdraw.addActionListener(this);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(100, 230, 120, 30);
        btnBack.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        btnBack.addActionListener(this);
        
        lblResult = new JLabel();
        lblResult.setBounds(180, 270, 300, 30);
        lblResult.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        lblBalance = new JLabel();
        lblBalance.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        add(lblInfo);
        add(lblAmount1);
        add(txtfldAmount1);
        add(lblAmount2);
        add(txtfldAmount2);
        add(btnWithdraw);
        add(btnBack);
        add(lblResult);
        add(lblBalance);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btnWithdraw){
            double amount1 = Double.parseDouble(txtfldAmount1.getText());
            double amount2 = Double.parseDouble(txtfldAmount2.getText());
            
            if(amount1 != 0 && amount2 != 0){
                if(amount1 == amount2){
                    if(account.getCash() >= amount2){
                        double newCash = account.getCash() - amount2;
                        account.setCash(newCash);
                        service.updateAccountCash(account);

                        lblResult.setBounds(100, 270, 300, 30);
                        lblResult.setForeground(Color.black);
                        lblResult.setText("   Successful Withdrawal.");
                        lblResult.setBorder( new MatteBorder(0, 1, 0, 0, Color.black));

                        lblBalance.setBounds(100, 300, 300, 30);
                        lblBalance.setText("   New Balance: PHP " + account.getCash());
                        lblBalance.setBorder( new MatteBorder(0, 1, 0, 0, Color.black));
                    }
                    else{
                        lblResult.setBounds(100, 270, 300, 30);
                        lblResult.setForeground(Color.red);
                        lblResult.setBorder( new MatteBorder(0, 1, 0, 0, Color.black));
                        lblResult.setText("   You don't have enough balance.");

                        lblBalance.setBounds(100, 300, 300, 30);
                        lblBalance.setText("   Current Balance: PHP " + account.getCash());
                        lblBalance.setBorder( new MatteBorder(0, 1, 0, 0, Color.black));
                    }
                }
                else{
                    lblResult.setBounds(150, 270, 300, 30);
                    lblResult.setForeground(Color.red);
                    lblResult.setBorder( new MatteBorder(0, 0, 0, 0, Color.black));
                    lblResult.setText("Amounts are not the same.");
                    lblBalance.setBounds(0, 0, 0, 0);
                }
            }
            else{
                    lblResult.setBounds(120, 270, 300, 30);
                    lblResult.setForeground(Color.red);
                    lblResult.setBorder( new MatteBorder(0, 0, 0, 0, Color.black));
                    lblResult.setText("Cannot withdraw empty amount.");
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