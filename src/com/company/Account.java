package com.company;

public class Account {
    private String number;
    private String name;
    private double balanceQuantity;
    private double balance;

    public Account(String number, String name, double balanceQuantity, double balance){
        this.number = number;
        this.name = name;
        this.balanceQuantity = balanceQuantity;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalanceQuantity() {
        return balanceQuantity;
    }

    public void setBalanceQuantity(double quantity) {
        this.balanceQuantity = quantity;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    @Override
    public String toString() {
        return "Number - " + getNumber() +
                "; Name - " + getName() +
                "; Quantity - " + getBalanceQuantity() +
                "; Balance - " + getBalance();
    }
}
