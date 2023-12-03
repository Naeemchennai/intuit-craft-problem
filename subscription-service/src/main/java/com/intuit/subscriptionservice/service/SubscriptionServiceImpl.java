package com.intuit.subscriptionservice.service;

import com.intuit.subscriptionservice.dto.NewSubscriptionReqDTO;
import com.intuit.subscriptionservice.dto.SubscriptionDTO;
import com.intuit.subscriptionservice.entity.Subscription;
import com.intuit.subscriptionservice.mapper.subscription.NewSubscriptionMapper;
import com.intuit.subscriptionservice.mapper.subscription.SubscriptionMapper;
import com.intuit.subscriptionservice.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionMapper subscriptionMapper;
    private final NewSubscriptionMapper newSubscriptionMapper;

    @Override
    public SubscriptionDTO createNewSubscription(final NewSubscriptionReqDTO newSubscriptionReqDTO) {
        Subscription savedSubscription = subscriptionRepository.save(newSubscriptionMapper.apply(newSubscriptionReqDTO));
        return subscriptionMapper.toDto(savedSubscription);
    }

    @Override
    public SubscriptionDTO getSubscription(String clientId) {
        Subscription subscription = subscriptionRepository.findByClientId(clientId).orElse(new Subscription());
        return subscriptionMapper.toDto(subscription);
    }


    @Override
    public SubscriptionDTO updateSubscription(final SubscriptionDTO subscriptionDTO) {
        Subscription subscription = subscriptionMapper.toEntity(subscriptionDTO);
        Subscription updateSubscription = subscriptionRepository.save(subscription);
        return subscriptionMapper.toDto(updateSubscription);
    }
}
