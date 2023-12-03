package com.intuit.clientservice.repository;

import com.intuit.clientservice.entity.profile.ClientProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<ClientProfile, String> {
}
