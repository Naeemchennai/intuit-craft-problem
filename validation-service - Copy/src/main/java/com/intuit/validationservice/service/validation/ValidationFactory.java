package com.intuit.validationservice.service.validation;

import com.intuit.validationservice.entity.profile.ClientProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static org.apache.logging.log4j.util.Strings.isBlank;

@Service
@RequiredArgsConstructor
public class ValidationFactory {
    private final NewClientValidator newClientValidator;
    private final ExistingClientValidator existingClientValidator;

    public Validator getValidator(ClientProfile clientProfile) {
        if (isBlank(clientProfile.getId())) {
            return newClientValidator;
        }
        return existingClientValidator;
    }
}
