package com.autowave.service.validations.subscription;

import com.autowave.base.enums.ValidationActionsEnum;
import com.autowave.base.exception.Message;
import com.autowave.base.validation.IValidations;
import com.autowave.entities.Plan;
import com.autowave.entities.Subscription;
import com.autowave.enums.ErrorEnum;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubscriptionValidate implements IValidations<Subscription> {

    @Override
    public void validate(Subscription data, ValidationActionsEnum action, List<Message> messagesToThrow) {
        if (action.equals(ValidationActionsEnum.CREATE) || action.equals(ValidationActionsEnum.UPDATE)) {
            if (data.getUser() == null || data.getUser().getId() == null) {
                messagesToThrow.add(new Message(ErrorEnum.SUBSCRIPTION_USER_INVALID));
            }
            if (data.getPlan() == null || data.getPlan().getId() == null) {
                messagesToThrow.add(new Message(ErrorEnum.SUBSCRIPTION_PLAN_INVALID));
            }
            if (data.getStartDate() == null || data.getExpirationDate() == null || !data.getExpirationDate().isAfter(data.getStartDate())) {
                messagesToThrow.add(new Message(ErrorEnum.SUBSCRIPTION_DATE_INVALID));
            }
            if (data.getStatus() == null) {
                messagesToThrow.add(new Message(ErrorEnum.SUBSCRIPTION_STATUS_INVALID));
            }
        }
    }
}