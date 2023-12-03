package com.intuit.validationservice.service.client;

import com.intuit.validationservice.dto.client.ClientValidationStatusDTO;
import com.intuit.validationservice.entity.status.ClientValidationStatus;
import com.intuit.validationservice.mapper.ClientValidationStatusMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class ClientProfileValidationServiceImpl implements ClientProfileValidationService {
    private final WebClient clientProfileWebClient;
    private final ClientValidationStatusMapper clientValidationStatusMapper;

    public ClientValidationStatus validClientProfile(Object object) {

        return clientProfileWebClient.post()
                .uri("/client/validate")
                .bodyValue(object)
                .retrieve()
                .bodyToMono(ClientValidationStatusDTO.class)
                .blockOptional()
                .map(clientValidationStatusMapper::toEntity).orElse(new ClientValidationStatus());

    }
}
