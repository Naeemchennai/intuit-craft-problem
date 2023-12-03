package com.intuit.validationservice.service.update;

import com.intuit.validationservice.dto.validation.ValidationStatusUpdateDTO;
import com.intuit.validationservice.entity.status.ValidationStatus;
import com.intuit.validationservice.entity.validation.ClientProfileValidation;
import com.intuit.validationservice.entity.validation.ProductValidationResult;
import com.intuit.validationservice.exception.client.InvalidClientException;
import com.intuit.validationservice.exception.client.InvalidStatusException;
import com.intuit.validationservice.exception.client.ProductAlreadyValidateException;
import com.intuit.validationservice.repository.ClientProfileValidationRepository;
import com.intuit.validationservice.service.client.ClientUpdateService;
import com.intuit.validationservice.util.StatusValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.intuit.validationservice.entity.status.ValidationStatus.*;
import static org.springframework.util.CollectionUtils.isEmpty;

@Service
@RequiredArgsConstructor
@Slf4j
public class ValidationUpdateServiceImpl implements ValidationUpdateService {

    private final ClientProfileValidationRepository clientProfileValidationRepository;
    private final ClientUpdateService clientUpdateService;

    @Override
    public void updateValidationStatus(ValidationStatusUpdateDTO validationStatusUpdateDTO) {
        ClientProfileValidation clientProfileValidation = clientProfileValidationRepository.findById(validationStatusUpdateDTO.getRequestId()).orElseThrow(InvalidClientException::new);
        Map<String, ProductValidationResult> productValidationResults = clientProfileValidation.getProductValidationResults();

        Map<String, ProductValidationResult> validationResultMap = updateProductValidation(productValidationResults, validationStatusUpdateDTO);
        clientProfileValidation.setProductValidationResults(validationResultMap);
        if (REJECTED.name().equals(validationStatusUpdateDTO.getStatus())) {
            clientProfileValidation.setValidationStatus(REJECTED);
        }
        ClientProfileValidation savedClientProfileValidation = clientProfileValidationRepository.save(clientProfileValidation);
        checkCompletions(savedClientProfileValidation);

    }

    public void checkCompletions(ClientProfileValidation savedClientProfileValidation) {
        List<String> productSubscriptions = savedClientProfileValidation.getProductSubscriptions();
        Map<String, ProductValidationResult> productValidationResults = savedClientProfileValidation.getProductValidationResults();
        ValidationStatus validationStatus = savedClientProfileValidation.getValidationStatus();
        if (productSubscriptions.size() == productValidationResults.keySet().size() && IN_PROGRESS.equals(validationStatus)) {
            clientUpdateService.updateClient(savedClientProfileValidation.getAuditRequestId());
            savedClientProfileValidation.setValidationStatus(COMPLETED);
            clientProfileValidationRepository.save(savedClientProfileValidation);
        }
    }

    private Map<String, ProductValidationResult> updateProductValidation(Map<String, ProductValidationResult> validationResultMap, ValidationStatusUpdateDTO validationStatusUpdateDTO) {

        String product = validationStatusUpdateDTO.getProduct();
        String status = validationStatusUpdateDTO.getStatus();
        if (isEmpty(validationResultMap)) {
            validationResultMap = new HashMap<>();
        }
        if (validationResultMap.containsKey(product)) {
            throw new ProductAlreadyValidateException();
        }
        if (StatusValidator.isValidStatus(status)) {
            throw new InvalidStatusException();
        }
        ProductValidationResult productValidationResult = new ProductValidationResult();
        productValidationResult.setStatus(status);

        validationResultMap.put(product, productValidationResult);

        return validationResultMap;
    }

}
