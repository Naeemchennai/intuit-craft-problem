package com.intuit.clientservice.entity.profile;

import com.intuit.clientservice.entity.address.BusinessAddress;
import com.intuit.clientservice.entity.tax.TaxIdentifier;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "client_profile")
@Data
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
