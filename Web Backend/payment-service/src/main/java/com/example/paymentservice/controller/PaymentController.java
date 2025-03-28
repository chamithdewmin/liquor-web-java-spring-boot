package com.example.paymentservice.controller;

import com.example.paymentservice.model.Payment;
import com.example.paymentservice.service.PaymentService;
import org.springframework.http.ResponseEntity; //Used to return HTTP responses.
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //Marks this class as a Spring REST controller.
@RequestMapping("/payments")

public class PaymentController {
    //The PaymentService is injected through the constructor.
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<Payment> makePayment(@RequestBody Payment payment) {
        Payment processedPayment = paymentService.processPayment(payment);
        return ResponseEntity.ok(processedPayment);
    }

    @GetMapping //  New endpoint to fetch all payments
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<Payment> getPayment(@PathVariable Integer transactionId) { // Changed String to Integer
        Optional<Payment> paymentOptional = paymentService.getPaymentByTransactionId(transactionId);
        return paymentOptional
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add") //  New endpoint to add a payment
    public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) {
        Payment newPayment = paymentService.addPayment(payment);
        return ResponseEntity.ok(newPayment);
    }

    @DeleteMapping("/{transactionId}") //  New endpoint to delete a payment
    public ResponseEntity<Void> deletePayment(@PathVariable Integer transactionId) {
        paymentService.deletePaymentByTransactionId(transactionId);
        return ResponseEntity.noContent().build();
    }
}
