package com.autowave.service.validations.campaing;

import com.autowave.base.enums.ValidationActionsEnum;
import com.autowave.base.exception.Message;
import com.autowave.base.validation.IValidations;
import com.autowave.entities.Campaign;
import com.autowave.entities.Client;
import com.autowave.enums.ErrorEnum;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class CampaingValidate implements IValidations<Campaign> {

    @Override
    public void validate(Campaign data, ValidationActionsEnum action, List<Message> messagesToThrow) {

        if (action.equals(ValidationActionsEnum.CREATE) || action.equals(ValidationActionsEnum.UPDATE)) {

            if (data.getName() == null || data.getName().isBlank()) {
                messagesToThrow.add(new Message(ErrorEnum.MANDATORY_FIELD, "O campo Nome é obrigatório."));
            } else if (data.getName().length() < 3 || data.getName().length() > 100) {
                messagesToThrow.add(new Message(ErrorEnum.CAMPAIGN_INVALID_SIZE));
            }

            if (data.getScheduledDate() != null && data.getScheduledDate().isBefore(LocalDate.now())) {
                messagesToThrow.add(new Message(ErrorEnum.CAMPAIGN_INVALID_DATE));
            }

            if (data.getMessageTemplate() == null || data.getMessageTemplate().isBlank() || data.getMessageTemplate().length() > 500) {
                messagesToThrow.add(new Message(ErrorEnum.CAMPAIGN_TEMPLATE_INVALID));
            }

            if (data.getUser() == null || data.getUser().getId() == null) {
                messagesToThrow.add(new Message(ErrorEnum.CAMPAIGN_USER_INVALID));
            }
        }
    }
}