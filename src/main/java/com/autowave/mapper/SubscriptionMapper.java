package com.autowave.mapper;


import com.autowave.base.mapper.GenericMapper;
import com.autowave.dto.list.SubscriptionListDTO;
import com.autowave.dto.request.SubscriptionRequestDTO;
import com.autowave.dto.response.SubscriptionResponseDTO;
import com.autowave.entities.Subscription;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface SubscriptionMapper extends GenericMapper<SubscriptionRequestDTO, SubscriptionResponseDTO, SubscriptionListDTO, Subscription, Long> {
}
