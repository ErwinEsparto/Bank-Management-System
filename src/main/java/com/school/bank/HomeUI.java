package com.school.bank;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class HomeUI implements ActionListener {
    private JFrame home = new JFrame("Welcome");
    private JLabel lblBankname, lblInfo, lblEmail, lblPassword, lblResult;
    private JTextField txtfldEmail = new JTextField();
    private JPasswordField psswrdfldPassword = new JPasswordField();
    private JButton btnLogin;
    private BankFunctions function = new BankFunctions();
    
    HomeUI(){
        home.setSize(500, 500);
        home.setLayout(null);
        home.setDefaultCloseOperation(home.EXIT_ON_CLOSE);
        home.setVisible(true);
        home.setResizable(false);
        home.setLocationRelativeTo(null);
        
        lblBankname = new JLabel("PUP Bank Hub");
        lblBankname.setBounds(75, 80, 350, 50);
        lblBankname.setFont(new Font("Century Gothic", Font.BOLD, 50));
        
        lblInfo = new JLabel("Enter the following information to continue:");
        lblInfo.setBounds(85, 150, 320, 30);
        lblInfo.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        lblEmail = new JLabel("Email: ");
        lblEmail.setBounds(120, 190, 110, 30);
        lblEmail.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        lblPassword = new JLabel("Password: ");
        lblPassword.setBounds(120, 230, 110, 30);
        lblPassword.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        txtfldEmail.setBounds(215, 190, 150, 30);
        txtfldEmail.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        psswrdfldPassword.setBounds(215, 230, 150, 30);
        psswrdfldPassword.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        btnLogin = new JButton("Login");
        btnLogin.setBounds(215, 270, 150, 30);
        btnLogin.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        btnLogin.addActionListener(this);
        
        lblResult = new JLabel("");
        lblResult.setForeground(Color.red);
        lblResult.setBounds(222, 300, 150, 30);
        lblResult.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        
        home.add(lblBankname);
        home.add(lblInfo);
        home.add(lblEmail);
        home.add(lblPassword);
        home.add(txtfldEmail);
        home.add(psswrdfldPassword);
        home.add(btnLogin);
        home.add(lblResult);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btnLogin){
            String email = txtfldEmail.getText();
            String password = psswrdfldPassword.getText();
            BankAccountModel account = function.checkAccount(email, password);
            
            if (account != null){
                home.dispose();
                new MenuUI();
            }
            else {
                txtfldEmail.setText("");
                psswrdfldPassword.setText("");
                lblResult.setText("Incorrect Credentials.");
            }
        }
    }
}