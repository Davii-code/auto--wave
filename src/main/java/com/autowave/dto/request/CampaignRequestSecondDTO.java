package com.autowave.dto.request;

import com.autowave.base.annotation.MandatoryField;
import com.autowave.enums.CampaignType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CampaignRequestSecondDTO {

    private Long id;

    @MandatoryField(name = "Name")
    private String name;

}
