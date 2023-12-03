package com.intuit.validationservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.web.reactive.function.client.WebClient.builder;

@Configuration
@ConfigurationProperties
public class SubscriptionServiceConfig {

    @Value("${subscription.url}")
    private String subscriptionServiceUrl;

    @Bean
    public WebClient subcriptionWebClient(){

        return builder()
                .baseUrl(subscriptionServiceUrl)
                .build();
    }
}
