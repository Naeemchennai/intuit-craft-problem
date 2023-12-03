package com.intuit.validationservice.entity.subscription;

import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Data
public class Subscription {
    private String id;
    private String clientId;
    private List<String> products;

    public boolean isEmpty() {
        return CollectionUtils.isEmpty(products);
    }
}
