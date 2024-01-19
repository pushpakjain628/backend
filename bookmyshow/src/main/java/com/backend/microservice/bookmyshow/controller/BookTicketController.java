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
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8089/payment",String.class);
        return responseEntity.getBody();
    }

    @GetMapping("/book")
    public String bookTicket() {
        log.info("this is message");
        service.bookTicket();
        return "Success";
    }

}
