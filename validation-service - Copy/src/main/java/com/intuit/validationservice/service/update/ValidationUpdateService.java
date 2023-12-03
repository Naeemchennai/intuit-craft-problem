package com.intuit.validationservice.service.update;

import com.intuit.validationservice.dto.validation.ValidationStatusUpdateDTO;

public interface ValidationUpdateService {

    void updateValidationStatus(ValidationStatusUpdateDTO validationStatusUpdateDTO);
}
