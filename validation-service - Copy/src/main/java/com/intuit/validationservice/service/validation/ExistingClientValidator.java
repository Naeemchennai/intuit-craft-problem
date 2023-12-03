package com.intuit.validationservice.service.validation;

import com.intuit.validationservice.entity.context.ValidationContext;
import com.intuit.validationservice.entity.status.ValidationStatus;
import com.intuit.validationservice.entity.subscription.Subscription;
import com.intuit.validationservice.entity.validation.ClientProfileValidation;
import com.intuit.validationservice.service.subscription.SubscriptionService;
import com.intuit.validationservice.service.validation.subscription.SubscriptionValidator;
import com.intuit.validationservice.service.validation.subscription.SubscriptionValidatorFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExistingClientValidator extends Validator {
    private final SubscriptionService subscriptionService;
    private final SubscriptionValidatorFactory subscriptionValidatorFactory;

    @Override
    public ClientProfileValidation validate(ValidationContext validationContext, ClientProfileValidation clientProfileValidation) {

        try {
            Subscription clientSubscription = subscriptionService.getClientSubscription(validationContext.getClientProfile().getId());
            SubscriptionValidator subscriptionValidator = subscriptionValidatorFactory.getValidator(clientSubscription);
            subscriptionValidator.processSubscriptionValidation(validationContext, clientSubscription, clientProfileValidation);
        } catch (Exception ex) {
            clientProfileValidation.setValidationStatus(ValidationStatus.FAILED);
            log.warn("Exception occurred while processing = {}", ex);
        }
        return clientProfileValidation;
    }
}
