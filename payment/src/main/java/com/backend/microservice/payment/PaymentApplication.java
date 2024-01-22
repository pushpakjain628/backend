package com.backend.microservice.payment;

import com.backend.common.config.BackendBootstrapApplication;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;

@BackendBootstrapApplication
@Slf4j
public class PaymentApplication {
	private String propertyValue ="test";

	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class, args);
	}

	@PostConstruct
	public void justLog(){
		log.info("this is my application name :"+propertyValue);
	}
}
