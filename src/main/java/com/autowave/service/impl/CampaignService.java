package com.autowave.service.impl;

import com.autowave.base.service.impl.AbstractService;
import com.autowave.dto.list.CampaignListDTO;
import com.autowave.dto.request.CampaignRequestDTO;
import com.autowave.dto.response.CampaignResponseDTO;
import com.autowave.entities.Campaign;
import com.autowave.mapper.CampaingMapper;
import com.autowave.repository.CampaignRepository;
import com.autowave.service.ICampaingService;
import org.springframework.stereotype.Service;

@Service
public class CampaignService extends AbstractService<
        CampaignRequestDTO,
        CampaignResponseDTO,
        CampaignListDTO,
        Campaign,
        CampaignRepository,
        CampaingMapper,
        Long> implements ICampaingService {

    @Override
    protected void prepareToCreate(Campaign data) {
    }

    @Override
    protected void prepareToUpdate(Campaign dataDB) {
    }

    @Override
    protected void prepareToDelete(Campaign dataDB) {
    }
}
