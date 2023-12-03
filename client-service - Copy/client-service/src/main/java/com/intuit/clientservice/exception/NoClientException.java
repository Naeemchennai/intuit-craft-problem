package com.intuit.clientservice.exception;

public class NoClientException extends RuntimeException {
    public NoClientException() {
        super("No Client Present");
    }
}
