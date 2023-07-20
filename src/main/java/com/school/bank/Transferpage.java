package com.school.bank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Erwin Esparto
 */
public class Transferpage extends JFrame implements ActionListener {
    private final JLabel lblInfo, lblTransfer, lblNote, lblAmount, lblResult, lblBalance;
    private final JTextField txtfldAmount, txtfldTransfer;
    private final JButton btnTransfer, btnBack;
    private BankServices service = new BankServices();
    private BankAccount account;
    
    Transferpage(BankAccount account){
        this.account = account;
        setTitle("Transfer Cash");
        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        lblInfo = new JLabel("Provide the details for transferring: ");
        lblInfo.setBounds(80, 100, 350, 30);
        lblInfo.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        
        lblTransfer = new JLabel("Transfer to: ");
        lblTransfer.setBounds(110, 140, 110, 30);
        lblTransfer.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        txtfldTransfer = new JTextField();
        txtfldTransfer.setBounds(220, 140, 150, 30);
        txtfldTransfer.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        lblNote = new JLabel("Bank Number");
        lblNote.setBounds(260, 160, 110, 30);
        lblNote.setFont(new Font("Century Gothic", Font.ITALIC, 10));
        
        lblAmount = new JLabel("Amount: ");
        lblAmount.setBounds(110, 190, 110, 30);
        lblAmount.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        txtfldAmount = new JTextField();
        txtfldAmount.setBounds(220, 190, 150, 30);
        txtfldAmount.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        btnTransfer = new JButton("Transfer");
        btnTransfer.setBounds(220, 230, 150, 30);
        btnTransfer.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        btnTransfer.addActionListener(this);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(110, 230, 100, 30);
        btnBack.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        btnBack.addActionListener(this);
        
        lblResult = new JLabel();
        lblResult.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        lblBalance = new JLabel();
        lblBalance.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        
        add(lblInfo);
        add(lblTransfer);
        add(txtfldTransfer);
        add(lblNote);
        add(lblAmount);
        add(txtfldAmount);
        add(btnTransfer);
        add(btnBack);
        add(lblResult);
        add(lblBalance);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btnTransfer){
            String transferBanknumber = txtfldTransfer.getText();
            double cash = Double.parseDouble(txtfldAmount.getText());
            BankAccount transferAccount = service.checkBanknumber(transferBanknumber);
                
            if(transferAccount != null){
                Boolean accountCheck = isAccountSame(account, transferAccount);
                if(accountCheck == true){
                    if(cash != 0){
                        if(account.getCash() >= cash){
                            double ownerCash = account.getCash() - cash;
                            account.setCash(ownerCash);
                            double transferCash = transferAccount.getCash() + cash;
                            transferAccount.setCash(transferCash);
                            service.transferCash(account, transferAccount);
                            service.recordTransfer(account, transferAccount, cash);

                            lblResult.setBounds(110, 270, 300, 30);
                            lblResult.setForeground(Color.black);
                            lblResult.setBorder( new MatteBorder(0, 1, 0, 0, Color.black));
                            lblResult.setText("   Successfully transfered.");

                            lblBalance.setBounds(110, 300, 300, 30);
                            lblBalance.setBorder( new MatteBorder(0, 1, 0, 0, Color.black));
                            lblBalance.setText("   New Balance: PHP " + account.getCash());
                        }
                        else{
                            lblResult.setBounds(110, 270, 300, 30);
                            lblResult.setForeground(Color.red);
                            lblResult.setBorder( new MatteBorder(0, 1, 0, 0, Color.black));
                            lblResult.setText("   You don't have enough cash.");

                            lblBalance.setBounds(110, 300, 300, 30);
                            lblBalance.setBorder( new MatteBorder(0, 1, 0, 0, Color.black));
                            lblBalance.setText("   Current Balance: PHP " + account.getCash());
                        }
                    }
                    else{
                        lblResult.setBounds(130, 270, 300, 30);
                        lblResult.setForeground(Color.red);
                        lblResult.setBorder( new MatteBorder(0, 0, 0, 0, Color.black));
                        lblResult.setText("Cannot transfer empty amount.");
                        lblBalance.setBounds(0, 0, 0, 0);
                    }
                }
                else{
                    lblResult.setBounds(105, 270, 300, 30);
                    lblResult.setForeground(Color.red);
                    lblResult.setBorder( new MatteBorder(0, 0, 0, 0, Color.black));
                    lblResult.setText("Cannot transfer to the same account.");
                    lblBalance.setBounds(0, 0, 0, 0);
                }
                }
            else{
                lblResult.setBounds(140, 270, 300, 30);
                lblResult.setForeground(Color.red);
                lblResult.setBorder( new MatteBorder(0, 0, 0, 0, Color.black));
                lblResult.setText("Transfer account not found.");
                lblBalance.setBounds(0, 0, 0, 0);
            }
            
        }
        else if (e.getSource() == btnBack){
            dispose();
            Menupage menu = new Menupage();
            menu.setVisible(true);
        }
    }
    public Boolean isAccountSame(BankAccount owner, BankAccount transfer){
        return !owner.getBanknumber().equals(transfer.getBanknumber());
    }
}