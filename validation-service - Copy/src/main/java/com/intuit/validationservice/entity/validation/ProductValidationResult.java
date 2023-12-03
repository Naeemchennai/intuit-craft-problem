package com.intuit.validationservice.entity.validation;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
public class ProductValidationResult {
    private String status;
    private LocalDateTime localDateTime;
}
