package ru.sibadi.demowebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sibadi.demowebapp.domain.Payment;
import ru.sibadi.demowebapp.domain.Person;


public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    Payment findPaymentById(int id);
}
