package com.intuit.validationservice.dto.validation;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
@JsonSerialize
public class ValidationResultDTO {
    private String id;
    private String auditRequestId;
    private String clientId;
    private String validationStatus;
}
