package ru.sibadi.demowebapp.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person {

    private int id;
    private String name;
    private int salary;

    private final List<Payment> payments = new ArrayList<>();

    public Person(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void addPayment(Payment payment){
        this.payments.add(payment);
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void deletePaymentByDate(LocalDate date){
        payments.removeIf(payment -> payment.getDate().equals(date));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}