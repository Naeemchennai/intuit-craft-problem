package com.intuit.clientservice.dto.profile;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.intuit.clientservice.dto.address.BusinessAddressDTO;
import com.intuit.clientservice.dto.tax.TaxIdentifiersDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@JsonSerialize
@Getter
@Setter
public class ClientProfileReqDTO {
    private String id;
    @NotBlank(message = "Company name is empty")
    private String companyName;
    @NotBlank(message = "Legal name is empty")
    private String legalName;
    @NotBlank(message = "Legal Address is empty")
    private String legalAddress;
    @NotBlank(message = "email is empty")
    @Email(message = "email address is inavlid")
    private String email;
    private String website;
    @NotNull
    private TaxIdentifiersDTO taxIdentifier;
    @NotNull
    private BusinessAddressDTO businessAddress;
}
