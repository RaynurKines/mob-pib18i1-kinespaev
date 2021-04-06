package ru.sibadi.demowebapp.domain;

import java.time.LocalDate;

public class Payment{

    private LocalDate date;
    private int insSalary;

    public Payment(LocalDate date, int insSalary) {
        this.date = date;
        this.insSalary = insSalary;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getInsSalary() {
        return insSalary;
    }

    public void setInsSalary(int insSalary) {
        this.insSalary = insSalary;
    }
}
