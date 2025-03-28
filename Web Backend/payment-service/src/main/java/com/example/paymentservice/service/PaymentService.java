package com.example.paymentservice.service;

import com.example.paymentservice.model.Payment;
import com.example.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment processPayment(Payment payment) {
        payment.setStatus("SUCCESS");
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {  //  New method to find all payments
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentByTransactionId(Integer transactionId) { // Change String to Integer
        return paymentRepository.findByTransactionId(transactionId);
    }

    public Payment addPayment(Payment payment) { //  Method to add a new payment
        return paymentRepository.save(payment);
    }

    public void deletePaymentByTransactionId(Integer transactionId) { //  Method to delete a payment
        Optional<Payment> payment = paymentRepository.findByTransactionId(transactionId);
        payment.ifPresent(paymentRepository::delete);
    }
}
