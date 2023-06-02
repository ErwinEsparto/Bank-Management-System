package com.school.bank;

import java.time.LocalDate;

public class BankAccountModel {
    enum AccountType{
        Customer,
        Admin
    }
    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private AccountType type;
    private LocalDate dateCreated;
    
    BankAccountModel(String firstname, String lastname, String password, String email, AccountType type){
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.type = type;
        dateCreated = LocalDate.now();
    }
    
    public String getFirstname(){ return firstname; }
    public String getLastname(){ return lastname; }
    public String getPassword(){ return password; }
    public String getEmail(){ return email; }
    public AccountType getType(){ return type; }
    public LocalDate getCreation(){ return dateCreated; }
}