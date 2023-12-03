package com.intuit.validationservice.mapper;

import com.intuit.validationservice.dto.subscription.SubscriptionDTO;
import com.intuit.validationservice.entity.subscription.Subscription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {
    Subscription toEntity(SubscriptionDTO subscriptionDTO);
}
