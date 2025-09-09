package com.autowave.service.validations.client;

import com.autowave.base.enums.ValidationActionsEnum;
import com.autowave.base.exception.Message;
import com.autowave.base.validation.IValidations;
import com.autowave.entities.Client;
import com.autowave.entities.User;
import com.autowave.enums.ErrorEnum;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ClientValidate implements IValidations<Client> {

    @Override
    public void validate(Client data, ValidationActionsEnum action, List<Message> messagesToThrow) {
        if (action.equals(ValidationActionsEnum.CREATE) || action.equals(ValidationActionsEnum.UPDATE)) {
            if (data.getName() == null || data.getName().isBlank() || data.getName().length() < 3 || data.getName().length() > 100) {
                messagesToThrow.add(new Message(ErrorEnum.CLIENT_NAME_INVALID));
            }
            if (data.getTelephone() == null || data.getTelephone().isBlank() || !data.getTelephone().matches("\\d{10,11}")) {
                messagesToThrow.add(new Message(ErrorEnum.CLIENT_PHONE_INVALID));
            }
            if (data.getDateofbirth() != null && data.getDateofbirth().isAfter(LocalDate.now())) {
                messagesToThrow.add(new Message(ErrorEnum.CLIENT_BIRTH_DATE_INVALID));
            }
            if (data.getLastPurchase() != null && data.getLastPurchase().isAfter(LocalDate.now())) {
                messagesToThrow.add(new Message(ErrorEnum.CLIENT_LAST_PURCHASE_INVALID));
            }
            if (data.getUser() == null || data.getUser().getId() == null) {
                messagesToThrow.add(new Message(ErrorEnum.CLIENT_USER_INVALID));
            }
        }
    }
}
