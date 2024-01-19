package com.backend.core;

import com.backend.common.annotations.CustomSpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@CustomSpringBootApplication
@EnableEurekaServer
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

}
