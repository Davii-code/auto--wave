package com.autowave.mapper;

import com.autowave.base.mapper.GenericMapper;
import com.autowave.dto.list.UserListDTO;
import com.autowave.dto.request.UserRequestDTO;
import com.autowave.dto.response.UserResponseDTO;
import com.autowave.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface UserMapper extends GenericMapper<UserRequestDTO, UserResponseDTO, UserListDTO, User, Long> {
}
