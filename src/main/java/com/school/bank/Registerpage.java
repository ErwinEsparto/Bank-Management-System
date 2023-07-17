package com.school.bank;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Andrei Bodota
 */
public class Registerpage extends JFrame implements ActionListener {
    private final JLabel lblInfo, lblFName, lblLName, lblEmail, lblBankNumber, lblBankPin;
    private final JTextField txtfldFName, txtfldLName, txtfldEmail, txtfldBankNumber;
    private final JPasswordField psswrdfldBankPin = new JPasswordField();
    private final JButton btnRegister, btnBack;
    private BankServices service = new BankServices();
    
    Registerpage(){
        setTitle("Opening New Account");
        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
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
        
        Random rdn = new Random();
        String num = Integer.toString(rdn.nextInt(99999999));
        txtfldBankNumber = new JTextField(num);
        txtfldBankNumber.setBounds(220, 220, 150, 30);
        txtfldBankNumber.setEditable(false);
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
        
        add(lblInfo);
        add(lblFName);
        add(lblLName);
        add(lblEmail);
        add(lblBankNumber);
        add(lblBankPin);
        add(txtfldFName);
        add(txtfldLName);
        add(txtfldEmail);
        add(txtfldBankNumber);
        add(psswrdfldBankPin);
        add(btnRegister);
        add(btnBack);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btnRegister){
            String firstname = txtfldFName.getText();
            String lastname = txtfldLName.getText();
            String emailaddress = txtfldEmail.getText();
            String banknumber = txtfldBankNumber.getText();
            String password = psswrdfldBankPin.getText();

            if (txtfldFName.getText().isEmpty() == false && txtfldLName.getText().isEmpty() == false && txtfldEmail.getText().isEmpty() == false && txtfldBankNumber.getText().isEmpty() == false && psswrdfldBankPin.getText().isEmpty() == false){
                BankAccount account = new BankAccount(
                        firstname,
                        lastname,
                        emailaddress,
                        banknumber,
                        password,
                        BankAccount.AccountType.Customer,
                        0.0,
                        LocalDate.now()
                );
                //Insert database method here
                JOptionPane.showMessageDialog(this, "Succecssfully Registered.");
            }
            else{
                JOptionPane.showMessageDialog(this, "Some fields cannot be blank.");
            }
        }
        else if (e.getSource() == btnBack){
            dispose();
            Menupage menu = new Menupage();
            menu.setVisible(true);
        }
    }
}