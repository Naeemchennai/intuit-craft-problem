package com.intuit.clientservice.service;

import com.intuit.clientservice.dto.profile.ClientProfileReqDTO;

public interface ClientProfileService {
    ClientProfileReqDTO addClient(final ClientProfileReqDTO clientProfileReqDTO);

    ClientProfileReqDTO updateClient(final ClientProfileReqDTO clientProfileReqDTO);

    ClientProfileReqDTO getClient(String id);
}
