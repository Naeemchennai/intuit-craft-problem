package com.intuit.validationservice.controller;

import com.intuit.validationservice.dto.profile.ClientProfileReqDTO;
import com.intuit.validationservice.dto.validation.ValidationResultDTO;
import com.intuit.validationservice.dto.validation.ValidationStatusUpdateDTO;
import com.intuit.validationservice.service.ValidationService;
import com.intuit.validationservice.service.status.ValidationStatusService;
import com.intuit.validationservice.service.update.ValidationUpdateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/validation")
@Slf4j
public class ValidationController {

    private final ValidationService validationService;
    private final ValidationUpdateService validationUpdateService;
    private final ValidationStatusService validationStatusService;

    @PostMapping("/client")
    public ValidationResultDTO validateClient(@RequestBody ClientProfileReqDTO clientProfileReqDTO) {

        log.info("request received to validate the client = {}", clientProfileReqDTO);

        ValidationResultDTO validationResultDTO = validationService.saveAndValidate(clientProfileReqDTO);

        log.info("validation result = {}", validationResultDTO);

        return validationResultDTO;
    }

    @PostMapping("/update")
    public void updateValidationStatus(@RequestBody ValidationStatusUpdateDTO validationStatusUpdateDTO) {
        log.info("request to update client status = {}", validationStatusUpdateDTO);

        validationUpdateService.updateValidationStatus(validationStatusUpdateDTO);

        log.info("successfully validate update client status");

    }

    @GetMapping("/status")
    public ValidationResultDTO getValidationStatus(@RequestParam("requestId") String requestId) {
        log.info("getValidationStatus: requestId = {}", requestId);
        ValidationResultDTO validationResultDTO = validationStatusService.getStatus(requestId);
        log.info("getValidationStatus: successful");
        return validationResultDTO;
    }
}
