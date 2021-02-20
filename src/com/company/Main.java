package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        BuhBalance buhBalance = null;
        if(new File("Accounts.txt").exists()){
            System.out.println("File is exists");
            //чтение из файла
            Reader readerAccounts = new FileReader("Accounts.txt");
            BufferedReader bufferedReader = new BufferedReader(readerAccounts);
            List<Account> accounts = new ArrayList<>();
            while(true){
                String line = bufferedReader.readLine();
                if(line == null)
                    break;
                String[] splitedLine = line.split(";");
                Account account = new Account(splitedLine[0], splitedLine[1], Double.parseDouble(splitedLine[2]), Double.parseDouble(splitedLine[3]));
                accounts.add(account);
            }
            buhBalance = new BuhBalance(accounts);
        }
        else {
            buhBalance = new BuhBalance();
        }

        int number;
        buhBalance.createOperation(buhBalance.getAccounts().get(2), 10,buhBalance.getAccounts().get(1), 0,1000);
        buhBalance.createOperation(buhBalance.getAccounts().get(0), 10,buhBalance.getAccounts().get(2), 10,1000);
        buhBalance.createOperation(buhBalance.getAccounts().get(0), 5,buhBalance.getAccounts().get(2), 5,500);

        watchOperations(buhBalance);
        for (Account account : buhBalance.getAccounts()) {
            System.out.println(account);
        }
        //buhBalance.writeInTxtAccounts();
    }

    public static void watchOperations(BuhBalance buhBalance) {
        System.out.println("\nOperations:");
        for (Operation operation : buhBalance.getOperations()) {
            System.out.println(operation);
        }
        System.out.println("\n");
    }
}
