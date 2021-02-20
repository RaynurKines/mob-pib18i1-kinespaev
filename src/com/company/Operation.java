package com.company;

public class Operation {

    private Account debet;
    private double debetQuantity;
    private  Account credit;
    private double creditQuantity;
    private double money;


    public Operation(Account debet, double debetQuantity, Account credit, double creditQuantity, double money)
    {
        this.debet = debet;
        this.debetQuantity = debetQuantity;
        this.credit = credit;
        this.creditQuantity = creditQuantity;
        this.money = money;

        debet.setBalance(debet.getBalance() + money);
        debet.setBalanceQuantity(debet.getBalanceQuantity() + debetQuantity);
        credit.setBalance(credit.getBalance() - money);
        credit.setBalanceQuantity(credit.getBalanceQuantity() - creditQuantity);
    }

    public Account getDebet() {
        return debet;
    }

    public void setDebet(Account debet) {
        this.debet = debet;
    }

    public Account getCredit() {
        return credit;
    }

    public void setCredit(Account credit) {
        this.credit = credit;
    }
    @Override
    public String toString() {
        return "debet - " + debet.getNumber() +
                " credit - " + credit.getNumber() +
                " money - " + money;
    }
}
