package com.intuit.validationservice.service.client;

import com.intuit.validationservice.entity.audit.RequestAudit;
import com.intuit.validationservice.exception.client.ClientNotUpdateException;
import com.intuit.validationservice.repository.RequestAuditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientUpdateService {

    private final RequestAuditRepository requestAuditRepository;
    private final ClientService clientService;

    public void updateClient(String auditRequestId) {
        requestAuditRepository.findById(auditRequestId)
                .map(RequestAudit::getIncomingRequest)
                .map(clientService::update)
                .orElseThrow(ClientNotUpdateException::new);
    }
}
