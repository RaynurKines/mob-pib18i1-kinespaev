package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuhBalance {

    private final List<Account> accounts;
    private final List<Operation> operations = new ArrayList<>();
    public BuhBalance()
    {
        this.accounts = new ArrayList<>();
        accounts.add(new Account("41", "Товары", 0, 0));
        accounts.add(new Account("50", "Касса", 0, 10000));
        accounts.add(new Account("60", "Расчеты с поставщиками и подрядчиками", 0, 0));
        accounts.add(new Account("62", "Расчеты с покупателями и заказчиками", 0, 0));
        accounts.add(new Account("90", "Расчеты с персоналом по оплате труда", 0, 0));
    }

    public BuhBalance(List<Account> accounts)
    {
        this.accounts = accounts;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public Operation createOperation(Account a, double debetQuantity, Account b, double creditQuantity, double money) {
        Operation operation = new Operation(a, debetQuantity, b, creditQuantity, money);
        operations.add(operation);
        return operation;
    }

    public void writeInTxtAccounts(){

        try(FileWriter writer = new FileWriter("Accounts.txt")) {
            for (Account account : accounts) {
                String number = account.getNumber();
                String name = account.getName();
                String quantity = String.valueOf(account.getBalanceQuantity());
                String balance = String.valueOf(account.getBalance());
                writer.write(number + ";" + name + ";" + quantity + ";" + balance + System.getProperty("line.separator"));

            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }



}
