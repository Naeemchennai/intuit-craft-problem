package com.intuit.validationservice.service;

import com.intuit.validationservice.dto.profile.ClientProfileReqDTO;
import com.intuit.validationservice.dto.validation.ValidationResultDTO;

public interface ValidationService {

    ValidationResultDTO saveAndValidate(ClientProfileReqDTO clientProfileReqDTO);
}
