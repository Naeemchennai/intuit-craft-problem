package com.intuit.validationservice.dto.subscription;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;

import java.util.List;

@JsonSerialize
@Getter
public class SubscriptionDTO {
    private String id;
    private String clientId;
    private List<String> products;
}
