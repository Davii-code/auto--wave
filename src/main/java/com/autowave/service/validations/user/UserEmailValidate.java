package com.autowave.service.validations.user;

import com.autowave.base.enums.ValidationActionsEnum;
import com.autowave.base.exception.Message;
import com.autowave.base.validation.IValidations;
import com.autowave.entities.User;
import com.autowave.enums.ErrorEnum;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserEmailValidate implements IValidations<User> {
    @Override
    public void validate(User data, ValidationActionsEnum action, List<Message> messagesToThrow) {
        if (action.equals(ValidationActionsEnum.CREATE) || action.equals(ValidationActionsEnum.UPDATE)) {
            if (data.getEmail() != null) {
                EmailValidator emailValidator = new EmailValidator();
                emailValidator.isValid(data.getEmail(), null);
                messagesToThrow.add(new Message(ErrorEnum.EMAIL_EXISTS));
            }
        }
    }
}
