package com.school.bank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RegisterUI implements ActionListener {
    private JFrame register = new JFrame("Register");
    private JLabel lblInfo, lblFName, lblLName, lblEmail, lblBankNumber, lblBankPin, lblResult;
    private JTextField txtfldFName, txtfldLName, txtfldEmail, txtfldBankNumber;
    private JPasswordField psswrdfldBankPin = new JPasswordField();
    private JButton btnRegister, btnBack;
    
    RegisterUI(){
        register.setSize(500, 500);
        register.setLayout(null);
        register.setDefaultCloseOperation(register.EXIT_ON_CLOSE);
        register.setVisible(true);
        register.setResizable(false);
        register.setLocationRelativeTo(null);
        
        lblInfo = new JLabel("Provide the following information: ");
        lblInfo.setBounds(80, 60, 350, 30);
        lblInfo.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        
        lblFName = new JLabel("First Name: ");
        lblFName.setBounds(110, 100, 110, 30);
        lblFName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        lblLName = new JLabel("Last Name: ");
        lblLName.setBounds(110, 140, 110, 30);
        lblLName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        lblEmail = new JLabel("Email: ");
        lblEmail.setBounds(110, 180, 110, 30);
        lblEmail.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        lblBankNumber = new JLabel("Bank Number: ");
        lblBankNumber.setBounds(110, 220, 110, 30);
        lblBankNumber.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        lblBankPin = new JLabel("Bank Pin: ");
        lblBankPin.setBounds(110, 260, 110, 30);
        lblBankPin.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        txtfldFName = new JTextField();
        txtfldFName.setBounds(220, 100, 150, 30);
        txtfldFName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        txtfldLName = new JTextField();
        txtfldLName.setBounds(220, 140, 150, 30);
        txtfldLName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        txtfldEmail = new JTextField();
        txtfldEmail.setBounds(220, 180, 150, 30);
        txtfldEmail.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        txtfldBankNumber = new JTextField();
        txtfldBankNumber.setBounds(220, 220, 150, 30);
        txtfldBankNumber.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        psswrdfldBankPin.setBounds(220, 260, 150, 30);
        psswrdfldBankPin.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        btnRegister = new JButton("Register");
        btnRegister.setBounds(220, 300, 150, 30);
        btnRegister.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        btnRegister.addActionListener(this);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(110, 300, 100, 30);
        btnBack.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        btnBack.addActionListener(this);
        
        lblResult = new JLabel();
        lblResult.setBounds(160, 340, 300, 30);
        lblResult.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        register.add(lblInfo);
        register.add(lblFName);
        register.add(lblLName);
        register.add(lblEmail);
        register.add(lblBankNumber);
        register.add(lblBankPin);
        register.add(txtfldFName);
        register.add(txtfldLName);
        register.add(txtfldEmail);
        register.add(txtfldBankNumber);
        register.add(psswrdfldBankPin);
        register.add(btnRegister);
        register.add(btnBack);
        register.add(lblResult);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btnRegister){
            lblResult.setText("Successfully Registered.");
        }
        else if (e.getSource() == btnBack){
            register.dispose();
            new MenuUI();
        }
    }
}