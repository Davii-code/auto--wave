package com.autowave.service.validations.plan;

import com.autowave.base.enums.ValidationActionsEnum;
import com.autowave.base.exception.Message;
import com.autowave.base.validation.IValidations;
import com.autowave.entities.Plan;
import com.autowave.enums.ErrorEnum;
import com.autowave.enums.SubscriptionStatus;
import com.autowave.repository.SubscriptionRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlanDelete implements IValidations<Plan> {

    private final SubscriptionRepository subscriptionRepository;

    public PlanDelete(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }


    @Override
    public void validate(Plan data, ValidationActionsEnum action, List<Message> messagesToThrow) {
        if (action.equals(ValidationActionsEnum.DELETE)) {

            boolean hasActiveSubscriptions = subscriptionRepository.existsByPlanIdAndStatus(data.getId(), SubscriptionStatus.ACTIVE);

            if (hasActiveSubscriptions) {
                messagesToThrow.add(new Message(ErrorEnum.PLAN_DELETE_WITH_SUBSCRIPTION));
            }
        }
    }
}
