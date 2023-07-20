package com.school.bank;

import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author Erwin Esparto
 */
public class BankServices {
    private static BankSQLData sql = new BankSQLData();
    private ArrayList <BankAccount> accounts = sql.getAccounts();
    private ArrayList <Transaction> transactions = sql.getTransactions();
        
    public ArrayList<BankAccount> getAccounts(){ 
        return accounts; 
    }
    public ArrayList<Transaction> getTransactions(){ 
        return transactions; 
    }
    
    public BankAccount checkAccount(String email, String password){
        for (BankAccount account : accounts) {
        if (account.getEmail().equals(email) && account.getPassword().equals(password) && account.getType().equals(BankAccount.AccountType.Admin)) {
            return account;
        }
        }
        return null;
    }
    public BankAccount checkBanknumber(String banknumber){
        for (BankAccount account : accounts) {
        if (account.getBanknumber().equals(banknumber) && account.getType().equals(BankAccount.AccountType.Customer)) {
            return account;
        }
        }
        return null;
    }
    public void updateAccountCash(BankAccount account){
        sql.updateAccountCash(account);
    }
    public void updateBankPin(BankAccount account){
        sql.updateBankPin(account);
    }
    public void registerAccount(BankAccount account){
        sql.saveAccount(account);
    }
    public void transferCash(BankAccount owner, BankAccount transfer){
        sql.transferCash(owner, transfer);
    }
    public void recordTransaction(BankAccount account, Transaction.TransactionType type, double amount){
        if(Transaction.TransactionType.Withdraw == type){
            Transaction transaction = new Transaction(
                                account.getFirstname() + " " + account.getLastname(),
                                account.getBanknumber(), 
                                amount, 
                                Transaction.TransactionType.Withdraw,
                                account.getCash(), 
                                LocalDate.now());
            sql.saveWithdrawTransaction(transaction);
        }
        else{
            Transaction transaction = new Transaction(
                                account.getFirstname() + " " + account.getLastname(),
                                account.getBanknumber(), 
                                amount, 
                                Transaction.TransactionType.Deposit,
                                account.getCash(), 
                                LocalDate.now());
            sql.saveDepositTransaction(transaction);
        }
    }
    public void recordTransfer(BankAccount account, BankAccount transfer, double amount){
        Transaction transaction = new Transaction(
                                account.getFirstname() + " " + account.getLastname(),
                                account.getBanknumber(), 
                                amount, 
                                Transaction.TransactionType.Transfer,
                                account.getCash(), 
                                LocalDate.now());
        Transaction transaction2 = new Transaction(
                                transfer.getFirstname() + " " + transfer.getLastname(),
                                transfer.getBanknumber(), 
                                amount, 
                                Transaction.TransactionType.Receive,
                                transfer.getCash(), 
                                LocalDate.now());
        sql.saveTransfer(transaction, transaction2);
    }
}