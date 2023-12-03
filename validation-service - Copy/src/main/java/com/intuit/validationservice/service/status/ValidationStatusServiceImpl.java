package com.intuit.validationservice.service.status;

import com.intuit.validationservice.dto.validation.ValidationResultDTO;
import com.intuit.validationservice.entity.context.ValidationContext;
import com.intuit.validationservice.entity.status.ValidationStatus;
import com.intuit.validationservice.entity.validation.ClientProfileValidation;
import com.intuit.validationservice.mapper.ValidationResultDTOMappper;
import com.intuit.validationservice.repository.ClientProfileValidationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyMap;

@Service
@RequiredArgsConstructor
public class ValidationStatusServiceImpl implements ValidationStatusService {

    private final ClientProfileValidationRepository clientProfileValidationRepository;
    private final ValidationResultDTOMappper validationResultDTOMappper;

    @Override
    public ClientProfileValidation createNewStatus(ValidationContext validationContext) {
        ClientProfileValidation clientProfileValidation = new ClientProfileValidation();
        clientProfileValidation.setAuditRequestId(validationContext.getAuditRequestId());
        clientProfileValidation.setValidationStatus(ValidationStatus.IN_PROGRESS);
        clientProfileValidation.setClientId(validationContext.getClientProfile().getId());
        clientProfileValidation.setProductValidationResults(emptyMap());
        return clientProfileValidation;
    }

    @Override
    public ValidationResultDTO getStatus(String requestId) {
        ClientProfileValidation clientProfileValidation = clientProfileValidationRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Invalid Request Id"));

        return validationResultDTOMappper.apply(clientProfileValidation);
    }

}
