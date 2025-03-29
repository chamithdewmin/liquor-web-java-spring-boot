package com.example.paymentservice.controller;

import com.example.paymentservice.dto.PaymentDTO;
import com.example.paymentservice.model.Payment;
import com.example.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Constructor injection for PaymentService
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Endpoint to get all payments
    @GetMapping
    public ResponseEntity<List<PaymentDTO>> getAllPayments() {
        List<PaymentDTO> payments = paymentService.getAllPayments();
        return ResponseEntity.ok(payments);
    }

    @PutMapping("/{transactionId}")
    public ResponseEntity<String> updatePayment(@PathVariable Integer transactionId, @RequestBody Payment payment) {
        boolean isUpdated = paymentService.updatePayment(transactionId, payment);
        if (isUpdated) {
            return ResponseEntity.ok("Payment updated successfully!");
        } else {
            return ResponseEntity.status(404).body("Payment not found!");
        }
    }

    // Endpoint to get a payment by transaction ID
    @GetMapping("/{transactionId}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Integer transactionId) {
        Optional<Payment> paymentOptional = paymentService.getPaymentByTransactionId(transactionId);
        return paymentOptional
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<String> addPayment(@RequestBody Payment payment) {
        String newPayment = paymentService.addPayment(payment);
        return ResponseEntity.ok(newPayment);
    }

    // Endpoint to delete a payment by transaction ID
    @DeleteMapping("/{transactionId}")
    public ResponseEntity<String> deletePayment(@PathVariable Integer transactionId) {
        boolean isDeleted = paymentService.deletePayment(transactionId);

        if (isDeleted) {
            return ResponseEntity.ok("Payment Deleted Successfully!");
        } else {
            return ResponseEntity.status(404).body("Payment Not Found!");
        }
    }

}
