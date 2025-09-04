package com.autowave.service;

import com.autowave.base.service.IAbstractService;
import com.autowave.dto.request.UserRequestDTO;
import com.autowave.entities.EvolutionInstance;
import com.autowave.entities.User;

public interface IUserService extends IAbstractService<UserRequestDTO, User, Long> {
    EvolutionInstance getEvolutionInstanceByUserId(Long userId);
}
