package com.school.bank;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import javax.swing.*;

/**
 *
 * @author Erwin Esparto
 */
public class Transactionpage extends JFrame implements ActionListener{
    private final JLabel lblInfo, lblEnter, lblLogin, lblResult;
    private final JTextField txtLogin = new JTextField();
    private final JButton btnEnter, btnWithdraw, btnDeposit, btnTransfer, btnPin, btnBack;
    private final BankServices service = new BankServices();
    private BankAccount account;
    
    Transactionpage(){
        setTitle("Process Transaction");
        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        lblEnter = new JLabel("Enter a bank number to continue: ");
        lblEnter.setBounds(85, 100, 350, 30);
        lblEnter.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        
        lblLogin = new JLabel("Bank Number:");
        lblLogin.setBounds(95, 140, 200, 30);
        lblLogin.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        txtLogin.setBounds(205, 140, 200, 30);
        txtLogin.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        btnEnter = new JButton("Enter");
        btnEnter.setBounds(305, 180, 100, 30);
        btnEnter.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        btnEnter.addActionListener(this);
        
        lblResult = new JLabel();
        lblResult.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        lblInfo = new JLabel("Please choose a transaction: ");
        lblInfo.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        
        btnWithdraw = new JButton("Withdraw Cash");
        btnWithdraw.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        btnWithdraw.addActionListener(this);
        
        btnDeposit = new JButton("Deposit Cash");
        btnDeposit.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        btnDeposit.addActionListener(this);
        
        btnTransfer = new JButton("Transfer Cash");
        btnTransfer.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        btnTransfer.addActionListener(this);
        
        btnPin = new JButton("Change Pin");
        btnPin.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        btnPin.addActionListener(this);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(375, 420, 100, 30);
        btnBack.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        btnBack.addActionListener(this);
        
        add(lblEnter);
        add(lblInfo);
        add(lblLogin);
        add(txtLogin);
        add(btnEnter);
        add(lblResult);
        add(btnTransfer);
        add(btnWithdraw);
        add(btnDeposit);
        add(btnPin);
        add(btnBack);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        
        if (e.getSource() == btnBack){
            dispose();
            Menupage menu = new Menupage();
            menu.setVisible(true);
        }
        else if (e.getSource() == btnEnter){
            String banknumber = txtLogin.getText();
            account = service.checkBanknumber(banknumber);
            
            if(account != null){
                txtLogin.setEditable(false);
                btnEnter.setBounds(0, 0, 0, 0);
                
                lblResult.setForeground(Color.black);
                lblResult.setBounds(110, 180, 300, 30);
                lblResult.setText("Current Cash as of "+ LocalDate.now() +": PHP " + account.getCash());
                
                lblInfo.setBounds(110, 220, 350, 30);
                btnWithdraw.setBounds(35, 250, 200, 30);
                btnDeposit.setBounds(255, 250, 200, 30);
                btnTransfer.setBounds(35, 290, 200, 30);
                btnPin.setBounds(255, 290, 200, 30);
            }
            else{
                txtLogin.setText("");
                lblResult.setBounds(130, 180, 200, 30);
                lblResult.setText("Account not found.");
                lblResult.setForeground(Color.red);
            }
        }
        else if (e.getSource() == btnTransfer){
            dispose();
            Transferpage transfer = new Transferpage(account);
            transfer.setVisible(true);
        }
        else if (e.getSource() == btnWithdraw){
            dispose();
            Withdrawpage withdraw = new Withdrawpage(account);
            withdraw.setVisible(true);
        }
        else if (e.getSource() == btnDeposit){
            dispose();
            Depositpage deposit = new Depositpage(account);
            deposit.setVisible(true);
        }
        else if (e.getSource() == btnPin){
            dispose();
            Pinpage pin = new Pinpage(account);
            pin.setVisible(true);
        }
    }
}