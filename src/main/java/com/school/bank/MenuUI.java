package com.school.bank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuUI implements ActionListener{
    private JFrame menu = new JFrame("Menu");
    private JLabel lblInfo = new JLabel("Please choose a transaction: ");
    private JButton btnOpen, btnAccounts, btnProcess, btnHistory, btnSignout;
    
    MenuUI(){
        menu.setSize(500, 500);
        menu.setLayout(null);
        menu.setDefaultCloseOperation(menu.EXIT_ON_CLOSE);
        menu.setVisible(true);
        menu.setResizable(false);
        menu.setLocationRelativeTo(null);
        
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
        
        menu.add(lblInfo);
        menu.add(btnOpen);
        menu.add(btnProcess);
        menu.add(btnHistory);
        menu.add(btnAccounts);
        menu.add(btnSignout);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btnOpen){
            menu.dispose();
            new RegisterUI();
        }
        else if (e.getSource() == btnSignout){
            menu.dispose();
            new HomeUI();
        }
    }
}