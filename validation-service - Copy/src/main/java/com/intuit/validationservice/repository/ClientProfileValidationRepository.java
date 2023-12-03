package com.intuit.validationservice.repository;

import com.intuit.validationservice.entity.validation.ClientProfileValidation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientProfileValidationRepository extends MongoRepository<ClientProfileValidation, String> {
}
