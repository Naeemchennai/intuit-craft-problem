package com.intuit.validationservice.dto.validation;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
@JsonSerialize
public class ValidationStatusUpdateDTO {
    private String requestId;
    private String product;
    private String status;
}
