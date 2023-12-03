package com.intuit.subscriptionservice.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
@JsonSerialize
public class NewSubscriptionReqDTO {
    private String clientId;
}
