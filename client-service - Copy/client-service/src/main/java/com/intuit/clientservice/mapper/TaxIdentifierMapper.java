package com.intuit.clientservice.mapper;

import com.intuit.clientservice.dto.tax.TaxIdentifiersDTO;
import com.intuit.clientservice.entity.tax.TaxIdentifier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaxIdentifierMapper {
    TaxIdentifier toEntity(TaxIdentifiersDTO taxIdentifiersDTO);

    TaxIdentifiersDTO toDto(TaxIdentifier taxIdentifier);
}
