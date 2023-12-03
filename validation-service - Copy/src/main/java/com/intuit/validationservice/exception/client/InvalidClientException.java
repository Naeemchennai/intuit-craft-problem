package com.intuit.validationservice.exception.client;

public class InvalidClientException extends RuntimeException {

    public InvalidClientException() {
        super("Invalid request Id");
    }
}
