package com.school.bank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Erwin Esparto
 */
public class Menupage extends JFrame implements ActionListener{
    private final JLabel lblInfo = new JLabel("Please choose an action: ");
    private final JButton btnOpen, btnAccounts, btnProcess, btnHistory, btnSignout;
    
    Menupage(){
        setTitle("Menu");
        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        lblInfo.setBounds(110, 140, 350, 30);
        lblInfo.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        
        btnOpen = new JButton("Open New Account");
        btnOpen.setBounds(35, 180, 200, 30);
        btnOpen.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        btnOpen.addActionListener(this);
        
        btnAccounts = new JButton("View Accounts");
        btnAccounts.setBounds(255, 180, 200, 30);
        btnAccounts.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        btnAccounts.addActionListener(this);
        
        btnProcess = new JButton("Process Transaction");
        btnProcess.setBounds(35, 220, 200, 30);
        btnProcess.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        btnProcess.addActionListener(this);
        
        btnHistory = new JButton("Transaction History");
        btnHistory.setBounds(255, 220, 200, 30);
        btnHistory.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        btnHistory.addActionListener(this);
        
        btnSignout = new JButton("Sign Out");
        btnSignout.setBounds(375, 420, 100, 30);
        btnSignout.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        btnSignout.addActionListener(this);
        
        add(lblInfo);
        add(btnOpen);
        add(btnProcess);
        add(btnHistory);
        add(btnAccounts);
        add(btnSignout);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        dispose();
        if (e.getSource() == btnOpen){
            Registerpage register = new Registerpage();
            register.setVisible(true);
        }
        else if (e.getSource() == btnAccounts){
            ViewAccountspage accounts = new ViewAccountspage();
            accounts.setVisible(true);
        }
        else if (e.getSource() == btnProcess){
            Transactionpage tp = new Transactionpage();
            tp.setVisible(true);
        }
        else if (e.getSource() == btnHistory){
            
        }
        else if (e.getSource() == btnSignout){
            JOptionPane.showMessageDialog(this, "You are now signing out.");
            Homepage home = new Homepage();
            home.setVisible(true);
        }
    }
}