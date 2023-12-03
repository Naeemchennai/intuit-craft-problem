package com.intuit.subscriptionservice.service;

import com.intuit.subscriptionservice.dto.NewSubscriptionReqDTO;
import com.intuit.subscriptionservice.dto.SubscriptionDTO;

public interface SubscriptionService {
    SubscriptionDTO createNewSubscription(NewSubscriptionReqDTO subscriptionDTO);

    SubscriptionDTO getSubscription(String clientId);

    SubscriptionDTO updateSubscription(SubscriptionDTO subscriptionDTO);
}
