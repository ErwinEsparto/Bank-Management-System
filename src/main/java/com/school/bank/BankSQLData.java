package com.school.bank;

import java.sql.*;
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
}