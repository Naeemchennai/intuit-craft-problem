package com.intuit.validationservice.repository;

import com.intuit.validationservice.entity.audit.RequestAudit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RequestAuditRepository extends MongoRepository<RequestAudit, String> {
}
