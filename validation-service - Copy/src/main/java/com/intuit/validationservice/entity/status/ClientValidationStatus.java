package com.intuit.validationservice.entity.status;

import lombok.Data;

@Data
public class ClientValidationStatus {
    private boolean isValid;
    private String status;
}
