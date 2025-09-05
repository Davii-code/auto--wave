package com.autowave.service.validations.client;

import com.autowave.base.enums.ValidationActionsEnum;
import com.autowave.base.exception.Message;
import com.autowave.base.validation.IValidations;
import com.autowave.entities.Client;
import com.autowave.enums.ErrorEnum;
import com.autowave.repository.CampaignRepository;
import com.autowave.repository.DispatchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientDelete implements IValidations<Client> {
    private final CampaignRepository campaignRepository;
    private final DispatchRepository dispatchRepository;

    public ClientDelete(CampaignRepository campaignRepository, DispatchRepository dispatchRepository) {
        this.campaignRepository = campaignRepository;
        this.dispatchRepository = dispatchRepository;
    }


    @Override
    public void validate(Client data, ValidationActionsEnum action, List<Message> messagesToThrow) {
        if (action.equals(ValidationActionsEnum.DELETE)) {

            boolean hasCampaigns = campaignRepository.existsByUserId(data.getId());

            if (hasCampaigns) {
                messagesToThrow.add(new Message(ErrorEnum.CLIENT_DELETE_WITH_CAMPAIGN));
            }

            boolean hasDispatchs = dispatchRepository.existsByClientId(data.getId());

            if (hasDispatchs) {
                messagesToThrow.add(new Message(ErrorEnum.CLIENT_DELETE_WITH_DISPATCH));
            }
        }
    }
}
