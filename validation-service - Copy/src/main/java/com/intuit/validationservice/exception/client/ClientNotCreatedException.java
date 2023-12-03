package com.intuit.validationservice.exception.client;

public class ClientNotCreatedException extends RuntimeException{
    public ClientNotCreatedException(){
        super("Unable to create client");
    }
}
