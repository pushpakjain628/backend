package com.backend.microservice.bookmyshow.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookTicketService {

    public void bookTicket(){
        log.info("Ticket Booked");
    }

}

