package com.autowave.mapper;


import com.autowave.base.mapper.GenericMapper;
import com.autowave.dto.list.PlanListDTO;
import com.autowave.dto.request.PlanRequestDTO;
import com.autowave.dto.response.PlanResponseDTO;
import com.autowave.entities.Plan;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface PlanMapper extends GenericMapper<PlanRequestDTO, PlanResponseDTO, PlanListDTO, Plan, Long> {
}
