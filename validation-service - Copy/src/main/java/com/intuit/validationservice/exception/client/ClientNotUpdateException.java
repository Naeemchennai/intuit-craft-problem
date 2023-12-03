package com.intuit.validationservice.exception.client;

public class ClientNotUpdateException extends RuntimeException {
    public ClientNotUpdateException(){
        super("Unable to update client");
    }
}
