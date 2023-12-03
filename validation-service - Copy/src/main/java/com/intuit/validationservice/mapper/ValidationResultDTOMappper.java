package com.intuit.validationservice.mapper;

import com.intuit.validationservice.dto.validation.ValidationResultDTO;
import com.intuit.validationservice.entity.validation.ClientProfileValidation;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ValidationResultDTOMappper implements Function<ClientProfileValidation, ValidationResultDTO> {
    @Override
    public ValidationResultDTO apply(ClientProfileValidation clientProfileValidation) {
        ValidationResultDTO validationResultDTO = new ValidationResultDTO();
        validationResultDTO.setValidationStatus(clientProfileValidation.getValidationStatus().name());
        validationResultDTO.setClientId(clientProfileValidation.getClientId());
        validationResultDTO.setAuditRequestId(clientProfileValidation.getAuditRequestId());
        validationResultDTO.setId(clientProfileValidation.getId());
        return validationResultDTO;
    }
}
