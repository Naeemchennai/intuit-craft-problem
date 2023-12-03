package com.intuit.validationservice.service.status;

import com.intuit.validationservice.dto.validation.ValidationResultDTO;
import com.intuit.validationservice.entity.context.ValidationContext;
import com.intuit.validationservice.entity.validation.ClientProfileValidation;

public interface ValidationStatusService {

    ClientProfileValidation createNewStatus(ValidationContext validationContext);

    ValidationResultDTO getStatus(String requestId);
}
