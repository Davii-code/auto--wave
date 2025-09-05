package com.autowave.controller.impl;

import com.autowave.base.controller.impl.AbstractCrudController;
import com.autowave.controller.ICampaingController;
import com.autowave.dto.list.CampaignListDTO;
import com.autowave.dto.report.CampaignStatsDTO;
import com.autowave.dto.request.CampaignRequestDTO;
import com.autowave.dto.response.CampaignResponseDTO;
import com.autowave.entities.Campaign;
import com.autowave.mapper.CampaingMapper;
import com.autowave.service.impl.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    private CampaignService campaignService;

    @GetMapping("/{id}/stats")
    public ResponseEntity<CampaignStatsDTO> getStats(@PathVariable Long id) {
        return ResponseEntity.ok(campaignService.getStats(id));
    }

    @GetMapping("/stats/all")
    public ResponseEntity<List<CampaignStatsDTO>> getAllStats(@RequestParam Long userId) {
        return ResponseEntity.ok(campaignService.getAllStats(userId));
    }
}
