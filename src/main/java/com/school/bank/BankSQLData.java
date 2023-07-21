package com.school.bank;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;


/**
 *
 * @author Erwin Esparto
 */
public class BankSQLData {
    Connection connection;
    
    BankSQLData(){
        try {
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "root");
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    
    public ArrayList getAccounts(){
        ArrayList<BankAccount> BankAccounts = new ArrayList<BankAccount>();
        try {
            PreparedStatement accounts= (PreparedStatement) connection.prepareStatement("Select * from Accounts");
            ResultSet result = accounts.executeQuery();
                    
            while(result.next()){
                BankAccounts.add(new BankAccount(
                        result.getString("Firstname"),
                        result.getString("Lastname"),
                        result.getString("EmailAddress"),
                        result.getString("Banknumber"),
                        result.getString("Password"),
                        "Admin".equals(result.getString("Type")) ? BankAccount.AccountType.Admin : BankAccount.AccountType.Customer,
                        result.getDouble("Cash"),
                        result.getDate("DateCreated").toLocalDate()
                ));
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return BankAccounts;
    }
    public void updateAccountCash(BankAccount account){
        try {
            String query = "Update Accounts Set Cash ='" + account.getCash() + "' Where Banknumber='" + account.getBanknumber() + "'";
            Statement state = connection.createStatement();
            state.executeUpdate(query);
        } 
        catch (Exception exception) {
                exception.printStackTrace();
        }
    } 
    public void updateBankPin(BankAccount account){
        try {
            String query = "Update Accounts Set Password ='" + account.getPassword() + "' Where Banknumber='" + account.getBanknumber() + "'";
            Statement state = connection.createStatement();
            state.executeUpdate(query);
        } 
        catch (Exception exception) {
                exception.printStackTrace();
        }
    } 
    public void saveAccount(BankAccount account){
        try {
            String query = "INSERT INTO Accounts values('" + 
                    account.getFirstname() + "','" + 
                    account.getLastname() + "','" + 
                    account.getEmail() + "','" + 
                    account.getBanknumber() + "','" + 
                    account.getPassword() + "','" + 
                    "Customer" + "','" + 
                    "0" + "','" + 
                    LocalDate.now() +"')";
            Statement state = connection.createStatement();
            state.executeUpdate(query);
        } 
        catch (Exception exception) {
                exception.printStackTrace();
        }
    } 
    public void transferCash(BankAccount owner, BankAccount transfer){
        try {
            String query = "Update Accounts Set Cash ='" + owner.getCash()+ "' Where Banknumber='" + owner.getBanknumber() + "'";
            Statement state = connection.createStatement();
            state.executeUpdate(query);
            
            String query2 = "Update Accounts Set Cash ='" + transfer.getCash()+ "' Where Banknumber='" + transfer.getBanknumber() + "'";
            Statement state2 = connection.createStatement();
            state2.executeUpdate(query2);
        } 
        catch (Exception exception) {
                exception.printStackTrace();
        }
    }
    public ArrayList getTransactions(){
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        try {
            PreparedStatement accounts= (PreparedStatement) connection.prepareStatement("Select * from Transactions");
            ResultSet result = accounts.executeQuery();
                    
            while(result.next()){
                transactions.add(new Transaction(
                        result.getString("Name"),
                        result.getString("Banknumber"),
                        result.getDouble("Amount"),
                        "Withdraw".equals(result.getString("Type")) ? Transaction.TransactionType.Withdraw : "Deposit".equals(result.getString("Type")) ? Transaction.TransactionType.Deposit : "Transfer".equals(result.getString("Type")) ? Transaction.TransactionType.Transfer : Transaction.TransactionType.Receive,
                        result.getDouble("Balance"),
                        result.getDate("Date").toLocalDate()
                ));
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return transactions;
    }
    public void saveWithdrawTransaction(Transaction transaction){
        try {
            String query = "INSERT INTO Transactions values('" + 
                    transaction.getFullname() + "','" + 
                    transaction.getBanknumber()+ "','" + 
                    transaction.getAmount()+ "','" + 
                    "Withdraw" + "','" +
                    transaction.getBalance() + "','" + 
                    transaction.getTransactionDate()+"')";
            Statement state = connection.createStatement();
            state.executeUpdate(query);
        } 
        catch (Exception exception) {
                exception.printStackTrace();
        }
    } 
    public void saveDepositTransaction(Transaction transaction){
        try {
            String query = "INSERT INTO Transactions values('" + 
                    transaction.getFullname() + "','" + 
                    transaction.getBanknumber()+ "','" + 
                    transaction.getAmount() + "','" + 
                    "Deposit" + "','" +
                    transaction.getBalance() + "','" + 
                    transaction.getTransactionDate()+"')";
            Statement state = connection.createStatement();
            state.executeUpdate(query);
        } 
        catch (Exception exception) {
                exception.printStackTrace();
        }
    } 
    public void saveTransfer(Transaction owner, Transaction transfer){
        try {
            String query = "INSERT INTO Transactions values('" + 
                    owner.getFullname() + "','" + 
                    owner.getBanknumber()+ "','" + 
                    owner.getAmount()+ "','" + 
                    "Transfer" + "','" +
                    owner.getBalance() + "','" + 
                    owner.getTransactionDate()+"')";
            Statement state = connection.createStatement();
            state.executeUpdate(query);
            
            String query2 = "INSERT INTO Transactions values('" + 
                    transfer.getFullname() + "','" + 
                    transfer.getBanknumber()+ "','" + 
                    transfer.getAmount()+ "','" + 
                    "Receive" + "','" +
                    transfer.getBalance() + "','" + 
                    transfer.getTransactionDate()+"')";
            Statement state2 = connection.createStatement();
            state2.executeUpdate(query2);
        } 
        catch (Exception exception) {
                exception.printStackTrace();
        }
    } 
}