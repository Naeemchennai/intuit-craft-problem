package com.intuit.validationservice.exception.client;

public class ProductAlreadyValidateException extends RuntimeException{
    public ProductAlreadyValidateException() {
        super("Product Already validated");
    }
}
