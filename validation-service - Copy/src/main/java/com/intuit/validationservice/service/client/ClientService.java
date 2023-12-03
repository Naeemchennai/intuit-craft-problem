package com.intuit.validationservice.service.client;

import com.intuit.validationservice.entity.profile.ClientProfile;

public interface ClientService {
    ClientProfile createNew(ClientProfile clientProfile);

    ClientProfile update(ClientProfile clientProfile);

    ClientProfile getClient(String id);

}
