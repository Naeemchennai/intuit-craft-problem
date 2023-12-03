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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.intuit.validationservice.entity.context.ValidationContext.builder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ValidationServiceImplTest {

    @InjectMocks
    private ValidationServiceImpl validationService;
    @Mock
    private RequestAuditService requestAuditService;
    @Mock
    private ClientProfileMapper clientProfileMapper;
    @Mock
    private ValidationFactory validationFactory;
    @Mock
    private ValidationContextFunc validationContextFunc;
    @Mock
    private ValidationResultDTOMappper validationResultDTOMappper;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveAndValidate_ShouldSaveAndValidateClientProfile() {
        ClientProfileReqDTO clientProfileReqDTO = new ClientProfileReqDTO();
        ClientProfile clientProfile = new ClientProfile();
        when(clientProfileMapper.toEntity(clientProfileReqDTO)).thenReturn(clientProfile);


        ValidationContext validationContext = builder().clientProfile(clientProfile).auditRequestId("requestId").build();
        when(validationContextFunc.createContext(clientProfile, "requestId")).thenReturn(validationContext);

        Validator validator = mock(Validator.class);
        when(validationFactory.getValidator(clientProfile)).thenReturn(validator);

        ClientProfileValidation clientProfileValidation = new ClientProfileValidation();
        when(validator.validate(validationContext)).thenReturn(clientProfileValidation);

        ValidationResultDTO expectedResult = new ValidationResultDTO();
        when(validationResultDTOMappper.apply(clientProfileValidation)).thenReturn(expectedResult);

        ValidationResultDTO result = validationService.saveAndValidate(clientProfileReqDTO);

        assertEquals(expectedResult, result);

        verify(requestAuditService).saveRequest(clientProfile);
        verify(validationFactory).getValidator(clientProfile);
        verify(validator).validate(validationContext);
        verify(validationResultDTOMappper).apply(clientProfileValidation);
    }


}