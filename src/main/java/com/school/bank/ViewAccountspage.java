package com.school.bank;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Erwin Esparto
 */
public class ViewAccountspage extends JFrame implements ActionListener{
    private final JTable tblAccount;
    private final DefaultTableModel tblModel;
    private final JButton btnBack= new JButton("Back");
    private final BankServices service = new BankServices();
    private final ArrayList<BankAccount> accounts = service.getAccounts();
    
    ViewAccountspage(){
        setTitle("Customer Accounts");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        tblModel = new DefaultTableModel();
        tblModel.addColumn("Full Name");
        tblModel.addColumn("Banknumber");
        tblModel.addColumn("EmailAddress");
        tblModel.addColumn("DateCreated");
        
        for(BankAccount account: accounts){
            if (account.getType().equals(BankAccount.AccountType.Customer)) {
                tblModel.addRow(new Object[]{
                    account.getFirstname() + " " + account.getLastname(), 
                    account.getBanknumber(), 
                    account.getEmail(), 
                    account.getCreation()});
            }
        }
        tblAccount = new JTable(tblModel);
        tblAccount.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane = new JScrollPane(tblAccount);
        
        JPanel btnBackPanel = new JPanel();
        btnBack.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        btnBack.addActionListener(this);
        btnBackPanel.add(btnBack);
        
        add(scrollPane);
        add(btnBackPanel, BorderLayout.SOUTH);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        dispose();
        if (e.getSource() == btnBack){
            Menupage menu = new Menupage();
            menu.setVisible(true);
        }
    }
}