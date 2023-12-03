package com.intuit.clientservice.mapper;

import com.intuit.clientservice.dto.address.BusinessAddressDTO;
import com.intuit.clientservice.entity.address.BusinessAddress;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BusinessAddressMapper {
    BusinessAddress toEntity(BusinessAddressDTO businessAddressDTO);

    BusinessAddressDTO toDto(BusinessAddress businessAddress);
}
