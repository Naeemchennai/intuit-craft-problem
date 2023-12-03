package com.intuit.validationservice.entity.profile;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.intuit.validationservice.entity.address.BusinessAddress;
import com.intuit.validationservice.entity.tax.TaxIdentifier;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "client_profile")
@Data
@JsonSerialize
public class ClientProfile {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String companyName;
    private String legalName;
    private String email;
    private String legalAddress;
    private BusinessAddress businessAddress;
    private TaxIdentifier taxIdentifier;
    private String website;
}
