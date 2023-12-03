package com.intuit.validationservice.service;

import com.intuit.validationservice.dto.profile.ClientProfileReqDTO;
import com.intuit.validationservice.dto.validation.ValidationResultDTO;
import com.intuit.validationservice.entity.context.ValidationContext;
import com.intuit.validationservice.entity.profile.ClientProfile;
import com.intuit.validationservice.entity.validation.ClientProfileValidation;
import com.intuit.validationservice.mapper.ValidationResultDTOMappper;
import com.intuit.validationservice.mapper.clientprofile.ClientProfileMapper;
import com.intuit.validationservice.service.audit.RequestAuditService;
import com.intuit.validationservice.service.validation.ValidationFactory;
import com.intuit.validationservice.service.validation.Validator;
import com.intuit.validationservice.util.ValidationContextFunc;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class ValidationServiceImpl implements ValidationService {

    private final RequestAuditService requestAuditService;
    private final ClientProfileMapper clientProfileMapper;
    private final ValidationFactory validationFactory;
    private final ValidationContextFunc validationContextFunc;
    private final ValidationResultDTOMappper validationResultDTOMappper;

    @Override
    public ValidationResultDTO saveAndValidate(final ClientProfileReqDTO clientProfileReqDTO) {
        ClientProfile clientProfile = clientProfileMapper.toEntity(clientProfileReqDTO);
        String requestId = save(clientProfile);
        ClientProfileValidation clientProfileValidation = validate(validationContextFunc.createContext(clientProfile, requestId));
        return validationResultDTOMappper.apply(clientProfileValidation);
    }

    private String save(final ClientProfile clientProfile) {
        return requestAuditService.saveRequest(clientProfile);
    }

    private ClientProfileValidation validate(final ValidationContext validationContext) {
        Validator validator = validationFactory.getValidator(validationContext.getClientProfile());
        ClientProfileValidation clientProfileValidation = validator.validate(validationContext);
        return clientProfileValidation;
    }

}
