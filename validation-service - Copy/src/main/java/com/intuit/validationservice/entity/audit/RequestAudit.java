package com.intuit.validationservice.entity.audit;

import com.intuit.validationservice.entity.profile.ClientProfile;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class RequestAudit {

    private String id;
    private LocalDateTime localDateTime;
    private ClientProfile incomingRequest;
}
