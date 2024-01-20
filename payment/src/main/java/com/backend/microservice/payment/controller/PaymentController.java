package com.backend.microservice.payment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {
    @GetMapping("/payment")
    public String paymentService() {
        log.info("Payment Service called");
        return "payment microservice called..";
    }

}
