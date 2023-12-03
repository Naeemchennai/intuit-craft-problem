package com.intuit.clientservice.mapper;

import com.intuit.clientservice.dto.profile.ClientProfileReqDTO;
import com.intuit.clientservice.entity.profile.ClientProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {BusinessAddressMapper.class, TaxIdentifierMapper.class})
public interface ClientProfileMapper {
    ClientProfile toEntity(ClientProfileReqDTO clientProfileReqDTO);

    ClientProfileReqDTO toDto(ClientProfile clientProfile);

}
