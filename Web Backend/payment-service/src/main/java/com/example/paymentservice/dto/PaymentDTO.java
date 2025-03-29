package com.example.paymentservice.dto;

public class PaymentDTO {

    private int transactionId;
    private double amount;
    private String status;

    // Constructor to map Payment model to PaymentDTO
    public PaymentDTO(int transactionId, double amount, String status) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.status = status;
    }

    // Getters and Setters
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
