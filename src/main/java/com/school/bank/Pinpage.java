package com.school.bank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Erwin Esparto
 */
public class Pinpage extends JFrame implements ActionListener {
    private final JLabel lblInfo, lblOld, lblNew, lblConfirm, lblResult;
    private final JPasswordField passfldOld, passfldNew, passfldConfirm;
    private final JButton btnChange, btnBack;
    private BankServices service = new BankServices();
    private BankAccount account;
    
    Pinpage(BankAccount account){
        this.account = account;
        setTitle("Change Pin");
        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        lblInfo = new JLabel("Provide the details to change pin:");
        lblInfo.setBounds(70, 110, 350, 30);
        lblInfo.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        
        lblOld = new JLabel("Old Pin: ");
        lblOld.setBounds(100, 150, 110, 30);
        lblOld.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        passfldOld = new JPasswordField();
        passfldOld.setBounds(230, 150, 150, 30);
        passfldOld.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        lblNew = new JLabel("New Pin:  ");
        lblNew.setBounds(100, 190, 130, 30);
        lblNew.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        passfldNew = new JPasswordField();
        passfldNew.setBounds(230, 190, 150, 30);
        passfldNew.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        lblConfirm = new JLabel("Confirm New Pin:  ");
        lblConfirm.setBounds(100, 230, 140, 30);
        lblConfirm.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        passfldConfirm = new JPasswordField();
        passfldConfirm.setBounds(230, 230, 150, 30);
        passfldConfirm.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        btnChange = new JButton("Change");
        btnChange.setBounds(230, 270, 150, 30);
        btnChange.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        btnChange.addActionListener(this);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(100, 270, 120, 30);
        btnBack.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        btnBack.addActionListener(this);
        
        lblResult = new JLabel();
        lblResult.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        add(lblInfo);
        add(lblOld);
        add(passfldOld);
        add(lblNew);
        add(passfldNew);
        add(lblConfirm);
        add(passfldConfirm);
        add(btnChange);
        add(btnBack);
        add(lblResult);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btnChange){
            String oldPassword = passfldOld.getText();
            String newPassword = passfldNew.getText();
            String confirmPassword = passfldConfirm.getText();
            
            if(account.getPassword().equals(oldPassword)){
                if(!oldPassword.equals(confirmPassword)){
                    if (newPassword.equals(confirmPassword)){
                        account.setPassword(confirmPassword);
                        service.updateBankPin(account);

                        lblResult.setBounds(140, 310, 300, 30);
                        lblResult.setForeground(Color.black);
                        lblResult.setText("Sucessfully changed the pin.");
                    }
                    else{
                        lblResult.setBounds(140, 310, 300, 30);
                        lblResult.setForeground(Color.red);
                        lblResult.setText("New pins are not the same.");
                    }
                }
                else{
                    lblResult.setBounds(140, 310, 300, 30);
                    lblResult.setForeground(Color.red);
                    lblResult.setText("Error: Same new and old pin.");
                }
            }
            else{
                lblResult.setBounds(170, 310, 300, 30);
                lblResult.setForeground(Color.red);
                lblResult.setText("Old pin is incorrect.");
            }
        }
        else if (e.getSource() == btnBack){
            dispose();
            Menupage menu = new Menupage();
            menu.setVisible(true);
        }
    }
}