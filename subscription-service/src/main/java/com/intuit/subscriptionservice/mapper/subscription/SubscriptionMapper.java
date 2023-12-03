package com.intuit.subscriptionservice.mapper.subscription;

import com.intuit.subscriptionservice.dto.SubscriptionDTO;
import com.intuit.subscriptionservice.entity.Subscription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {
    Subscription toEntity(SubscriptionDTO subscriptionDTO);
    SubscriptionDTO toDto(Subscription subscription);
}
