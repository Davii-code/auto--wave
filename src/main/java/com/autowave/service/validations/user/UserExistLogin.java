package com.autowave.service.validations.user;

import com.autowave.base.enums.ValidationActionsEnum;
import com.autowave.base.exception.Message;
import com.autowave.base.validation.IValidations;
import com.autowave.entities.User;
import com.autowave.enums.ErrorEnum;
import com.autowave.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserExistLogin implements IValidations<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void validate(User data, ValidationActionsEnum action, List<Message> messagesToThrow) {
        if (action.equals(ValidationActionsEnum.CREATE) || action.equals(ValidationActionsEnum.UPDATE)) {
            if (data.getEmail() != null && userRepository.existsByEmail(data.getEmail())) {
                messagesToThrow.add(new Message(ErrorEnum.LOGIN_EXISTS));
            }
        }
    }
}
