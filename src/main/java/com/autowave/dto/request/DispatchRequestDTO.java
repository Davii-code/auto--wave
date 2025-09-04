package com.autowave.dto.request;

import com.autowave.base.annotation.MandatoryField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DispatchRequestDTO {

    @MandatoryField(name = "Campaign ID")
    private CampaignRequestSecondDTO campaign;

    @MandatoryField(name = "Client ID")
    private ClientRequestSecondDTO client;

    private LocalDateTime sentAt;

    private Boolean delivered;

    private Boolean responded;
}
