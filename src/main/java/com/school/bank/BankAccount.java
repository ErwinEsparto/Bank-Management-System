package com.school.bank;

import java.time.LocalDate;

/**
 *
 * @author Erwin Esparto
 */
public class BankAccount {
    enum AccountType{
        Customer,
        Admin
    }
    private final String firstname;
    private final String lastname;
    private final String email;
    private final String banknumber;
    private String password;
    private final AccountType type;
    private double cash;
    private final LocalDate dateCreated;
    
    BankAccount(String firstname, String lastname, String email, String banknumber, String password, AccountType type, double cash, LocalDate dateCreated){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.banknumber = banknumber;
        this.type = type;
        this.cash = cash;
        this.dateCreated = dateCreated;
    }
    
    public String getFirstname(){ 
        return firstname; 
    }
    public String getLastname(){ 
        return lastname; 
    }
    public String getEmail(){ 
        return email; 
    }
    public String getBanknumber(){ 
        return banknumber; 
    }
    public String getPassword(){ 
        return password; 
    }
    public AccountType getType(){ 
        return type; 
    }
    public double getCash(){ 
        return cash; 
    }
    public LocalDate getCreation(){ 
        return dateCreated; 
    }
    public void setCash(double cash){
        this.cash = cash;
    }
    public void setPassword(String password){
        this.password = password;
    }
}