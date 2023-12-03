package com.intuit.clientservice.service;

import com.intuit.clientservice.dto.profile.ClientProfileReqDTO;
import com.intuit.clientservice.entity.profile.ClientProfile;
import com.intuit.clientservice.exception.NoClientException;
import com.intuit.clientservice.mapper.ClientProfileMapper;
import com.intuit.clientservice.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientProfileServiceImpl implements ClientProfileService {


    private final ClientRepository clientRepository;
    private final ClientProfileMapper clientProfileMapper;

    @Override
    public ClientProfileReqDTO addClient(final ClientProfileReqDTO clientProfileReqDTO) {
        log.info("adding Client");

        ClientProfile clientProfile = clientProfileMapper.toEntity(clientProfileReqDTO);
        ClientProfile saveClientProfile = clientRepository.save(clientProfile);

        log.info("Created Client Profile = {}", saveClientProfile.getId());
        return clientProfileMapper.toDto(saveClientProfile);
    }

    @Override
    public ClientProfileReqDTO updateClient(final ClientProfileReqDTO clientProfileReqDTO) {
        log.info("updating Client for id = {}", clientProfileReqDTO.getId());

        ClientProfile clientProfile = clientProfileMapper.toEntity(clientProfileReqDTO);
        clientRepository.findById(clientProfile.getId()).orElseThrow(() -> new RuntimeException("Invalid Client"));

        ClientProfile updateClientProfile = clientRepository.save(clientProfile);

        log.info("Client Profile Updated = {}", updateClientProfile);
        return clientProfileMapper.toDto(updateClientProfile);
    }

    @Override
    public ClientProfileReqDTO getClient(String clientId) {
        log.info("getting Client Details id = {}", clientId);

        ClientProfile clientProfile = clientRepository.findById(clientId).orElseThrow(NoClientException::new);

        log.info("clientProfile = {}", clientProfile);

        return clientProfileMapper.toDto(clientProfile);
    }
}
