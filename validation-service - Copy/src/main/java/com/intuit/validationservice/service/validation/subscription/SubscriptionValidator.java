package com.intuit.validationservice.service.validation.subscription;

import com.intuit.validationservice.entity.context.ValidationContext;
import com.intuit.validationservice.entity.subscription.Subscription;
import com.intuit.validationservice.entity.validation.ClientProfileValidation;

public interface SubscriptionValidator {
    void processSubscriptionValidation(ValidationContext validationContext, Subscription subscription, ClientProfileValidation clientProfileValidation);

}
