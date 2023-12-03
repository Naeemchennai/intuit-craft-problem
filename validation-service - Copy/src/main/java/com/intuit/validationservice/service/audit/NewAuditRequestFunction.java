package com.intuit.validationservice.service.audit;

import com.intuit.validationservice.entity.audit.RequestAudit;
import com.intuit.validationservice.entity.profile.ClientProfile;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.function.Function;

@Service
public class NewAuditRequestFunction implements Function<ClientProfile, RequestAudit> {
    @Override
    public RequestAudit apply(ClientProfile clientProfile) {
        RequestAudit requestAudit = new RequestAudit();
        requestAudit.setIncomingRequest(clientProfile);
        requestAudit.setLocalDateTime(LocalDateTime.now());
        return requestAudit;
    }
}
