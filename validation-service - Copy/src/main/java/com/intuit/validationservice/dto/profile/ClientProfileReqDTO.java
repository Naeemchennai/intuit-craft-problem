package com.intuit.validationservice.dto.profile;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.intuit.validationservice.dto.address.BusinessAddressDTO;
import com.intuit.validationservice.dto.tax.TaxIdentifiersDTO;
import lombok.Getter;
import lombok.Setter;

@JsonSerialize
@Getter
@Setter
public class ClientProfileReqDTO {
    private String id;
    private String companyName;
    private String legalName;
    private String legalAddress;
    private String email;
    private String website;
    private TaxIdentifiersDTO taxIdentifier;
    private BusinessAddressDTO businessAddress;
}
