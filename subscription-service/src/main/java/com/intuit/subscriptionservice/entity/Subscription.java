package com.intuit.subscriptionservice.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document
@Data
public class Subscription {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String clientId;
    private List<String> products;
}
