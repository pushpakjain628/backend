package com.backend.microservice.payment.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@Builder
@ToString
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    private String paymentFor;
    private String userName;
    private String userId;
    private String paymentAmount;
}
