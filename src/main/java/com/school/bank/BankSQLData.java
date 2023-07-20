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
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "01152003");
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
}