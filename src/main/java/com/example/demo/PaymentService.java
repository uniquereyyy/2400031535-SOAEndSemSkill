package com.example.demo;

public class PaymentService {

    public String processPayment(double amount, String details) {
        validatePaymentDetails(amount, details);
        return "Payment Successful";
    }

    public void validatePaymentDetails(double amount, String details) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount");
        }

        if (details == null || details.trim().isEmpty()) {
            throw new IllegalArgumentException("Payment details are missing");
        }
    }
}