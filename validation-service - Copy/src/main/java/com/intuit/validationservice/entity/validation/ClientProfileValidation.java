package com.intuit.validationservice.entity.validation;

import com.intuit.validationservice.entity.status.ValidationStatus;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document
@Data
public class ClientProfileValidation {
    private String id;
    private String auditRequestId;
    private String clientId;
    private ValidationStatus validationStatus;
    private List<String> productSubscriptions;
    private Map<String, ProductValidationResult> productValidationResults;
}
