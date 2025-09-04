package com.autowave.mapper;

import com.autowave.base.mapper.GenericMapper;
import com.autowave.dto.list.CampaignListDTO;
import com.autowave.dto.request.CampaignRequestDTO;
import com.autowave.dto.response.CampaignResponseDTO;
import com.autowave.entities.Campaign;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CampaingMapper extends GenericMapper<CampaignRequestDTO, CampaignResponseDTO, CampaignListDTO, Campaign, Long> {
}
