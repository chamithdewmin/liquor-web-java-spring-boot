package com.example.paymentservice.repository;

import com.example.paymentservice.dto.PaymentDTO;
import com.example.paymentservice.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    // Query method to find payment by transaction ID
    Optional<Payment> findByTransactionId(Integer transactionId);

    // Custom query to fetch all payments and return as PaymentDTO
    @Query("SELECT new com.example.paymentservice.dto.PaymentDTO(p.transactionId, p.amount, p.status) FROM Payment p")
    List<PaymentDTO> findAllPayments();
}
