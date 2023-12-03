package com.intuit.validationservice.util;

import com.intuit.validationservice.entity.status.ValidationStatus;

public class StatusValidator {

    public static boolean isValidStatus(String status) {
        for (ValidationStatus value : ValidationStatus.values()) {
            if (value.equals(status)) {
                return true;
            }
        }
        return false;

    }
}
