package com.mathsena.jobsapi.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    public void handleException(MathodAr e) {
        // Handle the exception
        System.out.println("An error occurred: " + e.getMessage());
    }
}
