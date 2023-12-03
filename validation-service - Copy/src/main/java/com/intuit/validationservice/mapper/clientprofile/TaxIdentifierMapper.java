package com.intuit.validationservice.mapper.clientprofile;


import com.intuit.validationservice.dto.tax.TaxIdentifiersDTO;
import com.intuit.validationservice.entity.tax.TaxIdentifier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaxIdentifierMapper {
    TaxIdentifier toEntity(TaxIdentifiersDTO taxIdentifiersDTO);

    TaxIdentifiersDTO toDto(TaxIdentifier taxIdentifier);
}
