package com.intuit.subscriptionservice.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.List;

@Data
@JsonSerialize
public class SubscriptionDTO {
    private String id;
    private String clientId;
    private List<String> products;
}
