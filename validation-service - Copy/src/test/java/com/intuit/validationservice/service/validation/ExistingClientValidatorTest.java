package com.intuit.validationservice.service.validation;

import com.intuit.validationservice.entity.context.ValidationContext;
import com.intuit.validationservice.entity.profile.ClientProfile;
import com.intuit.validationservice.entity.subscription.Subscription;
import com.intuit.validationservice.entity.validation.ClientProfileValidation;
import com.intuit.validationservice.service.subscription.SubscriptionService;
import com.intuit.validationservice.service.validation.subscription.NoSubscriptionValidator;
import com.intuit.validationservice.service.validation.subscription.SubscriptionValidatorFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ExistingClientValidatorTest {
    @InjectMocks
    private ExistingClientValidator existingClientValidator;
    @Mock
    private SubscriptionService subscriptionService;
    @Mock
    private SubscriptionValidatorFactory subscriptionValidatorFactory;

    @Mock
    private NoSubscriptionValidator noSubscriptionValidator;

    @Test
    void shouldSendMessageForExistingClient() {
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setId("id");
        ValidationContext validationContext = ValidationContext.builder().clientProfile(clientProfile).build();
        ClientProfileValidation clientProfileValidation = new ClientProfileValidation();
        Subscription subscription = new Subscription();

        when(subscriptionService.getClientSubscription(anyString())).thenReturn(subscription);
        when(subscriptionValidatorFactory.getValidator(new Subscription())).thenReturn(noSubscriptionValidator);
        doNothing().when(noSubscriptionValidator).processSubscriptionValidation(any(), any(), any());

        ClientProfileValidation res = existingClientValidator.validate(validationContext, clientProfileValidation);

        assertThat(clientProfileValidation).isEqualTo(res);

    }


}