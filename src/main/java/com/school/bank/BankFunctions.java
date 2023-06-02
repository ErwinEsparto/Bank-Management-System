package com.school.bank;

import java.util.*;

public class BankFunctions {
    private static BankAccountData data = new BankAccountData();
    private ArrayList <BankAccountModel> accounts = data.getAccounts();
        
    public BankAccountModel checkAccount(String email, String password){
        for (BankAccountModel account : accounts) {
        if (account.getEmail().equals(email) && account.getPassword().equals(password) && account.getType().equals(BankAccountModel.AccountType.Admin)) {
            return account;
        }
        }
        return null;
    }
}
