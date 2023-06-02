package com.school.bank;

import java.util.*;

public class BankAccountData {
    private ArrayList <BankAccountModel> accounts = new ArrayList<BankAccountModel>();
    
    BankAccountData(){ initializeAccounts(); }
    
    public ArrayList<BankAccountModel> getAccounts()
    { return accounts; }
    
    private void initializeAccounts(){
        BankAccountModel admin = new BankAccountModel
        ("Erwin", "Esparto", "123456", "espartoerwin@gmail.com", BankAccountModel.AccountType.Admin);
        accounts.add(admin);
        
        BankAccountModel customer1 = new BankAccountModel
        ("Customer", "A", "PasswordA", "customera@gmail.com", BankAccountModel.AccountType.Customer);
        accounts.add(customer1);
        
        BankAccountModel customer2 = new BankAccountModel
        ("Customer", "B", "PasswordB", "customerb@gmail.com", BankAccountModel.AccountType.Customer);
        accounts.add(customer2);
    }
}