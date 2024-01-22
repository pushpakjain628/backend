package com.backend.common.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Arrays;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse<T> implements Serializable {

    private String message;
    private T data;
    private String httpStatus;
    private String httpStatusCode;

    public APIResponse(String message){
        this.message = message;
        setSuccessMessage();
    }

    public APIResponse(String message,T data){
        this.message = message;
        this.data = data;
        setSuccessMessage();
    }

    private void setSuccessMessage() {
        this.httpStatus = "OK";
        this.httpStatusCode = "200";
    }
    // Constructors, getters, and setters as needed
}
