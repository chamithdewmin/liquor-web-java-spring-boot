package com.example.paymentservice.model;


import jakarta.persistence.*;

@Entity

@Table(name = "payments") // Database table name
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    private double amount;
    private String status;

    public int getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
