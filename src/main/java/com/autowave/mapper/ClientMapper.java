package com.autowave.mapper;

import com.autowave.base.mapper.GenericMapper;
import com.autowave.dto.list.ClientListDTO;
import com.autowave.dto.request.ClientRequestDTO;
import com.autowave.dto.response.ClientResponseDTO;
import com.autowave.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ClientMapper extends GenericMapper<ClientRequestDTO, ClientResponseDTO, ClientListDTO, Client, Long> {
}
