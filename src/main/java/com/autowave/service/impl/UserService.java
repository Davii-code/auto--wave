package com.autowave.service.impl;

import com.autowave.base.exception.Message;
import com.autowave.base.service.impl.AbstractService;
import com.autowave.dto.list.UserListDTO;
import com.autowave.dto.request.UserRequestDTO;
import com.autowave.dto.response.UserResponseDTO;
import com.autowave.entities.EvolutionInstance;
import com.autowave.entities.User;
import com.autowave.enums.ErrorEnum;
import com.autowave.mapper.UserMapper;
import com.autowave.reflection.ReflectionUtil;
import com.autowave.repository.UserRepository;
import com.autowave.service.IUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService extends AbstractService<UserRequestDTO, UserResponseDTO, UserListDTO, User, UserRepository, UserMapper, Long>
        implements IUserService {

    @Override
    protected void prepareToCreate(User data) {
        data.setPassword(encryptPassword(data.getPassword()));
    }

    @Override
    protected void prepareToUpdate(User dataDB) {
        dataDB.setPassword(encryptPassword(dataDB.getPassword()));
    }

    @Override
    protected void prepareToDelete(User dataDB) {

    }

    @Override
    protected void validateToMapCreate(UserRequestDTO dto, List<Message> messagesToThrow) {
        this.validateAnnotations(dto, messagesToThrow);
    }

    @Override
    protected void validateToMapUpdate(UserRequestDTO dto, List<Message> messagesToThrow) {
        this.validateAnnotations(dto, messagesToThrow);
    }

    private void validateAnnotations(Object object, List<Message> messagesToThrow) {
        Map<String, List<ErrorEnum>> mapErrors = ReflectionUtil.validateAnnotations(object);
        if (!mapErrors.isEmpty()) {
            for (String fieldKey : mapErrors.keySet()) {
                for (ErrorEnum errorEnum : mapErrors.get(fieldKey)) {
                    messagesToThrow.add(new Message(errorEnum, fieldKey));
                }
            }
        }
    }

    private String encryptPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    @Override
    public EvolutionInstance getEvolutionInstanceByUserId(Long userId) {
        return repository.getEvolutionInstanceByUserId(userId);
    }

}
