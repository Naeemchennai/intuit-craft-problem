package com.intuit.validationservice.mapper.clientprofile;

import com.intuit.validationservice.dto.profile.ClientProfileReqDTO;
import com.intuit.validationservice.entity.profile.ClientProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {BusinessAddressMapper.class, TaxIdentifierMapper.class})
public interface ClientProfileMapper {
    ClientProfile toEntity(ClientProfileReqDTO clientProfileReqDTO);

    ClientProfileReqDTO toDto(ClientProfile clientProfile);

}
