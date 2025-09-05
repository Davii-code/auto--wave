package com.autowave.service.validations.plan;

import com.autowave.base.enums.ValidationActionsEnum;
import com.autowave.base.exception.Message;
import com.autowave.base.validation.IValidations;
import com.autowave.entities.Payment;
import com.autowave.entities.Plan;
import com.autowave.enums.ErrorEnum;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class PlanValidate implements IValidations<Plan> {

    @Override
    public void validate(Plan data, ValidationActionsEnum action, List<Message> messagesToThrow) {
        if (action.equals(ValidationActionsEnum.CREATE) || action.equals(ValidationActionsEnum.UPDATE)) {
            if (data.getName() == null || data.getName().isBlank() || data.getName().length() < 3 || data.getName().length() > 100) {
                messagesToThrow.add(new Message(ErrorEnum.PLAN_NAME_INVALID));
            }
            if (data.getPrice() == null || data.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
                messagesToThrow.add(new Message(ErrorEnum.PLAN_PRICE_INVALID));
            }
            if (data.getBillingPeriod() == null) {
                messagesToThrow.add(new Message(ErrorEnum.PLAN_BILLING_PERIOD_INVALID));
            }
            if (data.getIncludedFeatures() != null && data.getIncludedFeatures().length() > 2000) {
                messagesToThrow.add(new Message(ErrorEnum.PLAN_FEATURES_INVALID));
            }
        }
    }
}
