package com.intuit.validationservice.service.validation;

import com.intuit.validationservice.entity.context.ValidationContext;
import com.intuit.validationservice.entity.profile.ClientProfile;
import com.intuit.validationservice.entity.validation.ClientProfileValidation;
import com.intuit.validationservice.service.client.ClientService;
import com.intuit.validationservice.util.ClientProfileValidationEnricher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.intuit.validationservice.entity.status.ValidationStatus.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class NewClientValidator extends Validator {

    private final ClientService clientService;
    private final ClientProfileValidationEnricher clientProfileValidationEnricher;

    @Override
    public ClientProfileValidation validate(ValidationContext validationContext, ClientProfileValidation clientProfileValidation) {
        try {
            ClientProfile clientProfile = clientService.createNew(validationContext.getClientProfile());
            clientProfileValidationEnricher.markCompleted(clientProfileValidation, clientProfile);
            log.info("Created new Client = {}", clientProfile);
        } catch (Exception exception) {
            log.warn("Exception occurred while creating new client= {}", exception);
            clientProfileValidation.setValidationStatus(FAILED);
        }
        return clientProfileValidation;
    }
}
