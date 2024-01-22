package com.backend.microservice.payment.service;

import com.backend.common.model.APIResponse;
import com.backend.microservice.payment.model.Payment;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public APIResponse performPayment(Payment paymentRequest){
        rabbitTemplate.convertAndSend("","payment",paymentRequest);
        return new APIResponse("Payment Proceed Further ");
    }



}
