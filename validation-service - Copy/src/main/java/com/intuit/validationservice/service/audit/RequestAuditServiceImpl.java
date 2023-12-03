package com.intuit.validationservice.service.audit;

import com.intuit.validationservice.dto.profile.ClientProfileReqDTO;
import com.intuit.validationservice.entity.audit.RequestAudit;
import com.intuit.validationservice.entity.profile.ClientProfile;
import com.intuit.validationservice.repository.RequestAuditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestAuditServiceImpl implements RequestAuditService {
    private final NewAuditRequestFunction newAuditRequestFunction;
    private final RequestAuditRepository requestAuditRepository;
    @Override
    public String saveRequest(ClientProfile clientProfile) {
        RequestAudit requestAudit = newAuditRequestFunction.apply(clientProfile);
        RequestAudit saverRequest = requestAuditRepository.save(requestAudit);
        return saverRequest.getId();
    }
}
