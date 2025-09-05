package com.autowave.service.validations.dispatch;

import com.autowave.base.enums.ValidationActionsEnum;
import com.autowave.base.exception.Message;
import com.autowave.base.validation.IValidations;
import com.autowave.entities.Client;
import com.autowave.entities.Dispatch;
import com.autowave.enums.ErrorEnum;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DispatchValidate implements IValidations<Dispatch> {

    @Override
    public void validate(Dispatch data, ValidationActionsEnum action, List<Message> messagesToThrow) {

        if (action.equals(ValidationActionsEnum.CREATE) || action.equals(ValidationActionsEnum.UPDATE)) {

            if (data.getCampaign() == null || data.getCampaign().getId() == null) {
                messagesToThrow.add(new Message(ErrorEnum.DISPATCH_CAMPAIGN_INVALID));
            }

            if (data.getClient() == null || data.getClient().getId() == null) {
                messagesToThrow.add(new Message(ErrorEnum.DISPATCH_CLIENT_INVALID));
            }

            if (data.getSentAt() != null && data.getSentAt().isAfter(LocalDateTime.now())) {
                messagesToThrow.add(new Message(ErrorEnum.DISPATCH_DATE_INVALID));
            }

            if (Boolean.TRUE.equals(data.getPending()) && (Boolean.TRUE.equals(data.getDelivered()) || Boolean.TRUE.equals(data.getResponded()))) {
                messagesToThrow.add(new Message(ErrorEnum.DISPATCH_STATUS_CONFLICT));
            }
            if (Boolean.TRUE.equals(data.getResponded()) && !Boolean.TRUE.equals(data.getDelivered())) {
                messagesToThrow.add(new Message(ErrorEnum.DISPATCH_STATUS_CONFLICT));
            }
        }
    }
}
