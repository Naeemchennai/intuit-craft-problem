package com.intuit.validationservice.dto.client;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@JsonSerialize
@Data
public class ClientValidationStatusDTO {
    private String isValid;
    private String status;
}
