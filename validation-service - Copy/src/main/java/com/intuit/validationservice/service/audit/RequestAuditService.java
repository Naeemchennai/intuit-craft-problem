package com.intuit.validationservice.service.audit;

import com.intuit.validationservice.entity.profile.ClientProfile;

public interface RequestAuditService {
    String saveRequest(ClientProfile clientProfile);
}
