package com.autowave.mapper;

import com.autowave.base.mapper.GenericMapper;
import com.autowave.dto.list.DispatchListDTO;
import com.autowave.dto.request.DispatchRequestDTO;
import com.autowave.dto.response.DispatchResponseDTO;
import com.autowave.entities.Dispatch;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface DispatchMapper extends GenericMapper<DispatchRequestDTO, DispatchResponseDTO, DispatchListDTO, Dispatch, Long> {
}
