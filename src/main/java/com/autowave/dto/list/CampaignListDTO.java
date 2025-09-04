package com.autowave.dto.list;

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
public class CampaignListDTO {
    private Long id;
    private String name;
    private CampaignType type;
    private LocalDate scheduledDate;
}

