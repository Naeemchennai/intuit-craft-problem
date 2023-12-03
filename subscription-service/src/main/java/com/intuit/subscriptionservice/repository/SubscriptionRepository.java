package com.intuit.subscriptionservice.repository;


import com.intuit.subscriptionservice.entity.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SubscriptionRepository extends MongoRepository<Subscription, String> {
    Optional<Subscription> findByClientId(String clientId);
}
