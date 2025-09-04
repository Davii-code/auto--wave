package com.autowave.service;

import com.autowave.base.service.IAbstractService;
import com.autowave.dto.request.CampaignRequestDTO;
import com.autowave.entities.Campaign;

public interface ICampaingService extends IAbstractService<CampaignRequestDTO, Campaign, Long> {
}
