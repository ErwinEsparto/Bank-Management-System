package com.school.bank;

import java.util.*;

/**
 *
 * @author Erwin Esparto
 */
public class BankServices {
    private static BankSQLData sql = new BankSQLData();
    private ArrayList <BankAccount> accounts = sql.getAccounts();
        
    public ArrayList<BankAccount> getAccounts(){ 
        return accounts; 
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
}