package com.autowave.dto.request;

import com.autowave.base.annotation.MandatoryField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestDTO {

    @MandatoryField(name = "Name")
    private String name;

    @MandatoryField(name = "Telephone")
    private String telephone;

    private LocalDate dateofbirth;

    private LocalDate lastpurchase;

    private UserRequestClientDTO user;
}
