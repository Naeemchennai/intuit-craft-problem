package com.intuit.validationservice.exception.client;

public class InvalidStatusException extends RuntimeException {
    public InvalidStatusException() {
        super("Invalid Status");
    }
}
