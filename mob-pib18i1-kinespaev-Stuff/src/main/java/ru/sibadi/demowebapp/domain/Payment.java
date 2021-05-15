package ru.sibadi.demowebapp.domain;

import javax.persistence.*;
import java.time.LocalDate;

@SequenceGenerator(
        name = "payment_seq_gen",
        sequenceName = "payment_seq",
        allocationSize = 1,
        initialValue = 1
)
@Entity
public class Payment{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_seq_gen")
    private int id;
    private LocalDate date;
    private double insSalary;

    public Payment() {
    }

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

    public double getInsSalary() {
        return insSalary*0.87;
    }

    public void setInsSalary(int insSalary) {
        this.insSalary = insSalary;
    }
}
