package com.intuit.validationservice.service.validation;

import com.intuit.validationservice.entity.context.ValidationContext;
import com.intuit.validationservice.entity.validation.ClientProfileValidation;
import com.intuit.validationservice.repository.ClientProfileValidationRepository;
import com.intuit.validationservice.service.status.ValidationStatusService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Setter
public abstract class Validator {

    @Autowired
    private ValidationStatusService validationStatusService;
    @Autowired
    private ClientProfileValidationRepository clientProfileValidationRepository;

    public ClientProfileValidation before(ValidationContext validationContext) {
        return validationStatusService.createNewStatus(validationContext);
    }

    public ClientProfileValidation validate(ValidationContext validationContext) {
        ClientProfileValidation newClientProfileValidation = before(validationContext);
        ClientProfileValidation result = validate(validationContext, newClientProfileValidation);
        after(result);
        return result;
    }

    public abstract ClientProfileValidation validate(ValidationContext validationContext, ClientProfileValidation clientProfileValidation);

    public void after(ClientProfileValidation clientProfileValidation) {
        clientProfileValidationRepository.save(clientProfileValidation);
    }

}
