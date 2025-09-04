package com.autowave.enums;

import com.autowave.base.enums.MessageCode;
import com.autowave.base.enums.MessageType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorEnum implements MessageCode {
    GENERAL_ERROR("MESSAGE.GENERAL.M1", MessageType.ERROR),
    MANDATORY_FIELD("MESSAGE.GENERAL.M4", MessageType.ERROR),
    PASSWORDS_DIFFERENT("MESSAGE.USER.M2", MessageType.ERROR),
    PASSWORD_INVALID("MESSAGE.USER.M3", MessageType.ERROR),
    EMAIL_INVALID("MESSAGE.GENERAL.M5", MessageType.ERROR),
    EMAIL_EXISTS("MESSAGE.GENERAL.M6", MessageType.ERROR),
    LOGIN_EXISTS("MESSAGE.USER.M1", MessageType.ERROR),
    PASSWORD_MIN_LENGTH("MESSAGE.USER.M4", MessageType.ERROR),
    PASSWORD_NUM_LETTER("MESSAGE.USER.M5", MessageType.ERROR),
    NUMBER_PHONE_INVALID("MESSAGE.GENERAL.M7", MessageType.ERROR),
    BIRTH_DAY_IS_AFTER("MESSAGE.PATIENT.M1", MessageType.ERROR),
    CPF_EXIST("MESSAGE.GENERAL.M8", MessageType.ERROR),
    CPF_INVALID("MESSAGE.GENERAL.M9", MessageType.ERROR),
    CEP_INVALID("MESSAGE.PATIENT.M3", MessageType.ERROR),
    USER_HASH_INSTANCE("MESSAGE.EVOLUTION.M1", MessageType.ERROR),
    USER_NOT_HAVE_INSTANCE("MESSAGE.EVOLUTION.M2", MessageType.ERROR),
    YOU_NOT_HAVE_INSTANCE("MESSAGE.EVOLUTION.M3", MessageType.ERROR);

    private final String code;
    private final MessageType type;
}
