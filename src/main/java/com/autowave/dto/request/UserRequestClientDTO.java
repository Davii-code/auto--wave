package com.autowave.dto.request;

import com.autowave.annotation.EmailValidate;
import com.autowave.annotation.PasswordValidate;
import com.autowave.base.annotation.MandatoryField;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestClientDTO {

    private Long id;

    @MandatoryField(name = "Nome")
    private String name;

    @MandatoryField(name = "Login")
    private String login;

}
