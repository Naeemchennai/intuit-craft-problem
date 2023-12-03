package com.intuit.validationservice.service.validation;

import com.intuit.validationservice.entity.profile.ClientProfile;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ValidationFactoryTest {

    @InjectMocks
    private ValidationFactory validationFactory;
    @Mock
    private NewClientValidator newClientValidator;
    @Mock
    private ExistingClientValidator existingClientValidator;

    @Test
    public void should_return_newClientValidator_IdIsEmpty() {
        Validator validator = validationFactory.getValidator(new ClientProfile());

        assertThat(newClientValidator).isEqualTo(validator);
    }

    @Test
    public void should_return_existingClientValidator() {
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setId("Id");

        Validator validator = validationFactory.getValidator(clientProfile);

        assertThat(existingClientValidator).isEqualTo(validator);
    }

}