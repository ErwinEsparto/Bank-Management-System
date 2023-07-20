package com.school.bank;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Mekaila Aguila
 */
public class Reportpage extends JFrame implements ActionListener{
    private final JTable tblTransactions;
    private final DefaultTableModel tblModel;
    private final JButton btnBack= new JButton("Back");
    private final BankServices service = new BankServices();
    private final ArrayList<Transaction> transactions = service.getTransactions();
    
    Reportpage(){
        setTitle("Transactions");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        tblModel = new DefaultTableModel();
        tblModel.addColumn("Name");
        tblModel.addColumn("Banknumber");
        tblModel.addColumn("Amount");
        tblModel.addColumn("Type");
        tblModel.addColumn("Balance");
        tblModel.addColumn("Date");
        
        for(Transaction transaction: transactions){
            tblModel.addRow(new Object[]{
            transaction.getFullname(), 
            transaction.getBanknumber(), 
            transaction.getAmount(), 
            transaction.getType(), 
            transaction.getBalance(), 
            transaction.getTransactionDate()});
        }
        tblTransactions = new JTable(tblModel);
        tblTransactions.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane = new JScrollPane(tblTransactions);
        
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