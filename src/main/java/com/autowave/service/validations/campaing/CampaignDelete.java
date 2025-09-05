package com.autowave.service.validations.campaing;

import com.autowave.base.enums.ValidationActionsEnum;
import com.autowave.base.exception.Message;
import com.autowave.base.validation.IValidations;
import com.autowave.entities.Campaign;
import com.autowave.enums.ErrorEnum;
import com.autowave.repository.DispatchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CampaignDelete implements IValidations<Campaign> {

    private final DispatchRepository dispatchRepository;

    public CampaignDelete(DispatchRepository dispatchRepository) {
        this.dispatchRepository = dispatchRepository;
    }

    @Override
    public void validate(Campaign data, ValidationActionsEnum action, List<Message> messagesToThrow) {
        if (action.equals(ValidationActionsEnum.DELETE)) {

            boolean hasDispatchs = dispatchRepository.existsByCampaignId(data.getId());

            if (hasDispatchs) {
                messagesToThrow.add(new Message(ErrorEnum.CAMPAIGN_DELETE_WITH_DISPATCH));
            }
        }
    }
}
