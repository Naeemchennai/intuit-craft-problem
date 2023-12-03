package com.intuit.validationservice.dto.tax;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@JsonSerialize
@Getter
@Setter
public class TaxIdentifiersDTO {
    private String pan;
    private String ein;
}
