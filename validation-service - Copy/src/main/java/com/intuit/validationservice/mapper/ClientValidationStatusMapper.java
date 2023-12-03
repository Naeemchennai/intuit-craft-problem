package com.intuit.validationservice.mapper;

import com.intuit.validationservice.dto.client.ClientValidationStatusDTO;
import com.intuit.validationservice.entity.status.ClientValidationStatus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientValidationStatusMapper {
ClientValidationStatus toEntity(ClientValidationStatusDTO clientValidationStatusDTO);
}
