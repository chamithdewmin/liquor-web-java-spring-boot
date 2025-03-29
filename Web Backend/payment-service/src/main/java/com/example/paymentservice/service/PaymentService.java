package com.example.paymentservice.service;

import com.example.paymentservice.model.Payment;
import com.example.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.paymentservice.dto.PaymentDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    // Method to get all payments
    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAllPayments();
    }

    // Method to get a payment by transaction ID
    public Optional<Payment> getPaymentByTransactionId(Integer transactionId) {
        return paymentRepository.findByTransactionId(transactionId);
    }

    public String addPayment(Payment payment) {
        paymentRepository.save(payment);
        return "Payment added successfully!";
    }

    public boolean updatePayment(Integer transactionId, Payment payment) {
        Optional<Payment> existingPayment = paymentRepository.findById(transactionId);

        if (existingPayment.isPresent()) {
            Payment paymentToUpdate = existingPayment.get();

            // Update the existing payment with new values
            paymentToUpdate.setAmount(payment.getAmount());
            paymentToUpdate.setStatus(payment.getStatus());

            paymentRepository.save(paymentToUpdate);
            return true;
        }
        return false;
    }

    public boolean deletePayment(Integer transactionId) {
        Optional<Payment> payment = paymentRepository.findById(transactionId);

        if (payment.isPresent()) {
            paymentRepository.delete(payment.get());
            return true; // Return true if deletion was successful
        }

        return false; // Return false if payment was not found
    }

}
