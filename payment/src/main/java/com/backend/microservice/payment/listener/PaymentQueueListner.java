package com.backend.microservice.payment.listener;

import com.backend.microservice.payment.model.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentQueueListner {

    @RabbitListener(queues = {"q.payment"})
    public void onPaymentRegistration(Payment paymentRequet){
        log.info("Payment is Successful: {}",paymentRequet.toString());
    }

}
