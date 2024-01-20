package com.backend.microservice.bookmyshow.controller;

import com.backend.microservice.bookmyshow.service.BookTicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class BookTicketController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BookTicketService service;

    @GetMapping("/bookmyshow")
    public String paymentService(){
        log.info("Book my Show service method called");
        log.info("External Service is calling");
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8087/payment",String.class);
        String response = responseEntity.getBody();
        log.info("Response Data: {}",response);
        return response;
    }

    @GetMapping("/book")
    public String bookTicket() {
        log.info("this is message");
        service.bookTicket();
        return "Success";
    }

}
