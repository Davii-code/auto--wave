package com.autowave.service.validations.payment;

import com.autowave.base.enums.ValidationActionsEnum;
import com.autowave.base.exception.Message;
import com.autowave.base.validation.IValidations;
import com.autowave.entities.Dispatch;
import com.autowave.entities.Payment;
import com.autowave.enums.ErrorEnum;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class PaymentValidate implements IValidations<Payment> {

    @Override
    public void validate(Payment data, ValidationActionsEnum action, List<Message> messagesToThrow) {
        if (action.equals(ValidationActionsEnum.CREATE)) {
            if (data.getSubscription() == null || data.getSubscription().getId() == null) {
                messagesToThrow.add(new Message(ErrorEnum.PAYMENT_SUBSCRIPTION_INVALID));
            }
            if (data.getAmount() == null || data.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
                messagesToThrow.add(new Message(ErrorEnum.PAYMENT_AMOUNT_INVALID));
            }
            if (data.getStatus() == null) {
                messagesToThrow.add(new Message(ErrorEnum.PAYMENT_STATUS_INVALID));
            }
            if (data.getCorrelationId() == null || data.getCorrelationId().isBlank()) {
                messagesToThrow.add(new Message(ErrorEnum.PAYMENT_DUPLICATED));
            }
        }
    }
}
