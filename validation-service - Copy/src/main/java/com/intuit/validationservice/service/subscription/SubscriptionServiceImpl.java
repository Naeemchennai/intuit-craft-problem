package com.intuit.validationservice.service.subscription;

import com.intuit.validationservice.dto.subscription.SubscriptionDTO;
import com.intuit.validationservice.entity.subscription.Subscription;
import com.intuit.validationservice.mapper.SubscriptionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final WebClient subcriptionWebClient;
    private final SubscriptionMapper subscriptionMapper;

    @Override
    public Subscription getClientSubscription(String clientId) {
        return subcriptionWebClient.get().uri(
                        uriBuilder -> uriBuilder
                                .path("/api/subscription")
                                .queryParam("clientId", clientId)
                                .build()
                )
                .retrieve()
                .bodyToMono(SubscriptionDTO.class)
                .blockOptional()
                .map(subscriptionMapper::toEntity).orElse(new Subscription());
    }
}
