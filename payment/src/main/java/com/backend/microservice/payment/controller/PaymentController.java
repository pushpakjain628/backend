package com.backend.microservice.payment.controller;

import com.backend.common.model.APIResponse;
import com.backend.microservice.payment.model.Payment;
import com.backend.microservice.payment.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment")
    @Operation(
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation"),
                    @ApiResponse(responseCode = "400", description = "bad request"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            }
    )
    public APIResponse processPayment(@RequestBody Payment paymentRequest){
        return paymentService.performPayment(paymentRequest);
    }

}
