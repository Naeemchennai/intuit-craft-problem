package com.intuit.clientservice.dto.tax;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@JsonSerialize
@Getter
@Setter
public class TaxIdentifiersDTO {
    @NotBlank(message = "PAN is empty")
    private String pan;
    @NotBlank(message = "EIN is empty")
    private String ein;
}
