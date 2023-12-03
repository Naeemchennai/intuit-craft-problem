package com.intuit.validationservice.service.client;

import com.intuit.validationservice.entity.profile.ClientProfile;
import com.intuit.validationservice.exception.client.ClientNotCreatedException;
import com.intuit.validationservice.exception.client.ClientNotUpdateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import static com.intuit.validationservice.constant.Constants.DURATION;
import static com.intuit.validationservice.constant.Constants.NO_OF_RETRY;
import static java.time.Duration.ofSeconds;
import static reactor.util.retry.Retry.fixedDelay;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {
    private static final String URI = "/api/client-profile";
    private final WebClient clientProfileWebClient;

    @Override
    public ClientProfile createNew(ClientProfile clientProfile) {
        return clientProfileWebClient.post()
                .uri(URI)
                .bodyValue(clientProfile)
                .retrieve()
                .bodyToMono(ClientProfile.class)
                .retryWhen(fixedDelay(NO_OF_RETRY, ofSeconds(DURATION)))
                .blockOptional()
                .orElseThrow(ClientNotCreatedException::new);
    }

    @Override
    public ClientProfile update(ClientProfile clientProfile) {
        return clientProfileWebClient.put()
                .uri(URI)
                .bodyValue(clientProfile)
                .retrieve()
                .bodyToMono(ClientProfile.class)
                .retryWhen(fixedDelay(NO_OF_RETRY, ofSeconds(DURATION)))
                .blockOptional()
                .orElseThrow(ClientNotUpdateException::new);
    }

    @Override
    public ClientProfile getClient(String clientId) {
        return clientProfileWebClient.get()
                .uri(URI)
                .attribute("id", clientId)
                .retrieve()
                .bodyToMono(ClientProfile.class)
                .retryWhen(fixedDelay(NO_OF_RETRY, ofSeconds(DURATION)))
                .blockOptional()
                .orElseThrow();
    }
}
