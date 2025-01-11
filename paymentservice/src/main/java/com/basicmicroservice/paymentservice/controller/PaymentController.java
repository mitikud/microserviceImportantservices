package com.basicmicroservice.paymentservice.controller;

import com.basicmicroservice.paymentservice.service.CartRestConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String port;
    @Autowired
    private CartRestConsumer consumer;  // HAS-A

    @GetMapping("/info")
    public ResponseEntity<String> showPaymentInfo() {
        return ResponseEntity.ok("FROM PAYMENT SERVICE, Port# is: " + port);
    }

    @GetMapping("/data")
    public String getPaymentData() {
        return "FROM PAYMENT-SERVICE : " + consumer.getCartInfo();
    }
}
