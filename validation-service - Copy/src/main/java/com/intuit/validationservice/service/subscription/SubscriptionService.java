package com.intuit.validationservice.service.subscription;

import com.intuit.validationservice.entity.subscription.Subscription;

public interface SubscriptionService {
    Subscription getClientSubscription(String clientId);
}
