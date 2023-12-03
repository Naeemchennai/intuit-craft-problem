package com.intuit.validationservice.service.validation.subscription;

import com.intuit.validationservice.entity.context.ValidationContext;
import com.intuit.validationservice.entity.profile.ClientProfile;
import com.intuit.validationservice.entity.status.ValidationStatus;
import com.intuit.validationservice.entity.subscription.Subscription;
import com.intuit.validationservice.entity.validation.ClientProfileValidation;
import com.intuit.validationservice.service.client.ClientService;
import com.intuit.validationservice.util.ClientProfileValidationEnricher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.intuit.validationservice.entity.status.ValidationStatus.*;
import static com.intuit.validationservice.entity.status.ValidationStatus.IN_PROGRESS;

@Service
@RequiredArgsConstructor
@Slf4j
public class NoSubscriptionValidator implements SubscriptionValidator {

    private final ClientService clientService;
    private final ClientProfileValidationEnricher clientProfileValidationEnricher;

    @Override
    public void processSubscriptionValidation(ValidationContext validationContext, Subscription subscription, ClientProfileValidation clientProfileValidation) {
        ClientProfile clientProfile = clientService.update(validationContext.getClientProfile());
        clientProfileValidationEnricher.markCompleted(clientProfileValidation, clientProfile);

    }
}
