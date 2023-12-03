package com.intuit.validationservice.service.validation.subscription;

import com.intuit.validationservice.entity.context.ValidationContext;
import com.intuit.validationservice.entity.subscription.Subscription;
import com.intuit.validationservice.entity.validation.ClientProfileValidation;
import com.intuit.validationservice.producer.ClientUpdateProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FanOutSubscriptionValidator implements SubscriptionValidator {

    private final ClientUpdateProducer clientUpdateProducer;
    @Override
    public void processSubscriptionValidation(ValidationContext validationContext, Subscription subscription, ClientProfileValidation clientProfileValidation) {
        clientProfileValidation.setProductSubscriptions(subscription.getProducts());
        clientUpdateProducer.publishClient(validationContext);
    }
}
