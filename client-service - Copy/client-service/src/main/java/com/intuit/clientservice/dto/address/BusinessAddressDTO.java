package com.intuit.clientservice.dto.address;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@JsonSerialize
@Getter
@Setter
public class BusinessAddressDTO {
    private String line1;
    private String line2;
    @NotBlank(message = "city is emtpy")
    private String city;
    @NotBlank(message = "state is emtpy")
    private String state;
    @NotBlank(message = "zip is empty")
    private String zip;
    @NotBlank(message = "country is empty")
    private String country;
}
