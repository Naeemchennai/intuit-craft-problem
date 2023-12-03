package com.intuit.validationservice.util;

import com.intuit.validationservice.entity.profile.ClientProfile;
import com.intuit.validationservice.entity.validation.ClientProfileValidation;
import org.springframework.stereotype.Service;

import static com.intuit.validationservice.entity.status.ValidationStatus.COMPLETED;

@Service
public class ClientProfileValidationEnricher {

    public void markCompleted(ClientProfileValidation clientProfileValidation, ClientProfile clientProfile) {
        clientProfileValidation.setValidationStatus(COMPLETED);
        clientProfileValidation.setClientId(clientProfile.getId());
    }
}
