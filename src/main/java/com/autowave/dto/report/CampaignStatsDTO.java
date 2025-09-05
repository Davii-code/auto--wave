package com.autowave.dto.report;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CampaignStatsDTO {
    private Long campaignId;
    private String campaignName;
    private Long totalDispatches;
    private Long sent;
    private Long delivered;
    private Long responded;
}
