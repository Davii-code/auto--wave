package com.autowave.base.validation;

import com.autowave.base.enums.ValidationActionsEnum;
import com.autowave.base.exception.Message;

import java.util.List;

public interface IValidations<MODEL> {
    void validate(MODEL data, ValidationActionsEnum action, List<Message> messagesToThrow);
}
