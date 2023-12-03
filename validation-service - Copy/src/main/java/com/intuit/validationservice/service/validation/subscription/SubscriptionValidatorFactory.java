package com.intuit.validationservice.service.validation.subscription;

import com.intuit.validationservice.entity.subscription.Subscription;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SubscriptionValidatorFactory {

    private final NoSubscriptionValidator noSubscriptionValidator;
    private final FanOutSubscriptionValidator fanOutSubscriptionValidator;

    public SubscriptionValidator getValidator(Subscription subscription) {
        if (subscription.isEmpty()) {
            return noSubscriptionValidator;
        }
        return fanOutSubscriptionValidator;
    }
}
