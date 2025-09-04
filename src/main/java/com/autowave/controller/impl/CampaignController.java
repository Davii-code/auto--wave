package com.autowave.controller.impl;

import com.autowave.base.controller.impl.AbstractCrudController;
import com.autowave.controller.ICampaingController;
import com.autowave.dto.list.CampaignListDTO;
import com.autowave.dto.request.CampaignRequestDTO;
import com.autowave.dto.response.CampaignResponseDTO;
import com.autowave.entities.Campaign;
import com.autowave.mapper.CampaingMapper;
import com.autowave.service.impl.CampaignService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api.version}/campaign")
public class CampaignController extends AbstractCrudController<
        CampaignRequestDTO,
        CampaignResponseDTO,
        CampaignListDTO,
        Campaign,
        CampaignService,
        CampaingMapper,
        Long> implements ICampaingController {
}
