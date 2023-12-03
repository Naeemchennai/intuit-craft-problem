package com.intuit.validationservice.service.client;

import com.intuit.validationservice.entity.status.ClientValidationStatus;

public interface ClientProfileValidationService {
    ClientValidationStatus validClientProfile(Object object);
}
