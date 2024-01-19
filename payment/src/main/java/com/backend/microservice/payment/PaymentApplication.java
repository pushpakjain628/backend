package com.backend.microservice.payment;

import com.backend.common.config.BackendBootstrapApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@BackendBootstrapApplication
@RestController
public class PaymentApplication {


	@GetMapping("/payment")
	public String paymentService(){
		return "payment microservice called..";
	}

	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class, args);
	}

}
