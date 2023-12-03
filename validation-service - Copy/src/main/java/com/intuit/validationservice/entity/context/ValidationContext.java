package com.intuit.validationservice.entity.context;

import com.intuit.validationservice.entity.profile.ClientProfile;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Getter
public class ValidationContext {
    private String auditRequestId;
    private ClientProfile clientProfile;

}
