package com.intuit.validationservice.util;

import com.intuit.validationservice.entity.context.ValidationContext;
import com.intuit.validationservice.entity.profile.ClientProfile;
import org.springframework.stereotype.Service;


@Service
public class ValidationContextFunc {

    public ValidationContext createContext(ClientProfile clientProfile, String requestId) {
        return ValidationContext.builder().auditRequestId(requestId).clientProfile(clientProfile).build();
    }
}
