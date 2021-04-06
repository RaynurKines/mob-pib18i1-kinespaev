//package ru.sibadi.demowebapp.repository;
//
//import org.springframework.stereotype.Repository;
//import ru.sibadi.demowebapp.domain.Payment;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Repository
//public class PaymentRepository {
//
//    private ArrayList<Payment> payments = new ArrayList<Payment>();
//
//    public List<Payment> findAllPayments() {
//        return payments;
//    }
//
//    public Payment findPaymentByData(Date date) {
//        Payment foundPayment = null;
//        for (Payment pay : payments) {
//            if (pay.getDate() == date) {
//                foundPayment = pay;
//            }
//        }
//        return foundPayment;
//    }
//}
