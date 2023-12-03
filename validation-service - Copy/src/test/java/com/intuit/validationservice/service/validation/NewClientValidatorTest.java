package com.intuit.validationservice.service.validation;

import com.intuit.validationservice.entity.context.ValidationContext;
import com.intuit.validationservice.entity.profile.ClientProfile;
import com.intuit.validationservice.entity.status.ValidationStatus;
import com.intuit.validationservice.entity.validation.ClientProfileValidation;
import com.intuit.validationservice.service.client.ClientService;
import com.intuit.validationservice.util.ClientProfileValidationEnricher;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class NewClientValidatorTest {

    @InjectMocks
    private NewClientValidator newClientValidator;
    @Mock
    private ClientService clientService;
    @Mock
    private ClientProfileValidationEnricher clientProfileValidationEnricher;

    @Test
    public void shouldCreateNewClientProfile() {
        ValidationContext validationContext = ValidationContext.builder().build();
        ClientProfileValidation clientProfileValidation = new ClientProfileValidation();
        clientProfileValidation.setValidationStatus(ValidationStatus.COMPLETED);

        when(clientService.createNew(Mockito.any())).thenReturn(new ClientProfile());
        Mockito.doNothing().when(clientProfileValidationEnricher).markCompleted(any(), any());

        ClientProfileValidation result = newClientValidator.validate(validationContext, clientProfileValidation);

        assertThat(clientProfileValidation.getValidationStatus()).isEqualTo(result.getValidationStatus());
    }

}