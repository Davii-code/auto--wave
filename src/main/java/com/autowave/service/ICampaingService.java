package com.autowave.service;

import com.autowave.base.service.IAbstractService;
import com.autowave.dto.report.CampaignStatsDTO;
import com.autowave.dto.request.CampaignRequestDTO;
import com.autowave.entities.Campaign;

import java.util.List;

public interface ICampaingService extends IAbstractService<CampaignRequestDTO, Campaign, Long> {
    public CampaignStatsDTO getStats(Long campaignId);
    public List<CampaignStatsDTO> getAllStats(Long userId);
}
