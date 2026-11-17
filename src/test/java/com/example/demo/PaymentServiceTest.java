package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PaymentServiceTest {

    PaymentService paymentService = new PaymentService();

    @Test
    void testValidPayment() {

        String result = paymentService.processPayment(
                1000, "UPI Payment");

        assertThat(result).isEqualTo("Payment Successful");
    }

    @Test
    void testInvalidAmount() {

        assertThatThrownBy(() ->
                paymentService.processPayment(
                        -100, "UPI Payment"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid amount");
    }

    @Test
    void testMissingDetails() {

        assertThatThrownBy(() ->
                paymentService.processPayment(
                        1000, ""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Payment details are missing");
    }
}