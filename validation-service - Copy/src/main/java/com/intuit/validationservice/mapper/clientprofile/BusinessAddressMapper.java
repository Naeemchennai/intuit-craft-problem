package com.intuit.validationservice.mapper.clientprofile;

import com.intuit.validationservice.dto.address.BusinessAddressDTO;
import com.intuit.validationservice.entity.address.BusinessAddress;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BusinessAddressMapper {
    BusinessAddress toEntity(BusinessAddressDTO businessAddressDTO);

    BusinessAddressDTO toDto(BusinessAddress businessAddress);
}
