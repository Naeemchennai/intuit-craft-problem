package com.intuit.subscriptionservice.mapper.subscription;

import com.intuit.subscriptionservice.dto.NewSubscriptionReqDTO;
import com.intuit.subscriptionservice.entity.Subscription;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class NewSubscriptionMapper implements Function<NewSubscriptionReqDTO, Subscription> {
    @Override
    public Subscription apply(NewSubscriptionReqDTO newSubscriptionReqDTO) {
        Subscription subscription = new Subscription();
        subscription.setClientId(newSubscriptionReqDTO.getClientId());
        return subscription;
    }
}
