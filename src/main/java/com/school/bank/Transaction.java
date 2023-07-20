package com.school.bank;

import java.time.LocalDate;

/**
 *
 * @author Erwin Esparto
 */

public class Transaction {
    public enum TransactionType{
        Withdraw,
        Deposit,
        Transfer,
        Receive
    }
    
    private final String fullName;
    private final String bankNumber;
    private final double amount;
    private final TransactionType type;
    private final double balance;
    private final LocalDate transactionDate;
    
    Transaction(String fullName, String bankNumber, double amount, TransactionType type, double balance, LocalDate transactionDate){
        this.fullName = fullName;
        this.bankNumber = bankNumber;
        this.amount = amount;
        this.type = type;
        this.balance = balance;
        this.transactionDate = transactionDate;
    }
    
    public String getFullname(){
        return fullName;
    }
    public String getBanknumber(){
        return bankNumber;
    }
    public double getAmount(){
        return amount;
    }
    public TransactionType getType(){
        return type;
    }
    public double getBalance(){
        return balance;
    }
    public LocalDate getTransactionDate(){
        return transactionDate;
    }
    
    
}