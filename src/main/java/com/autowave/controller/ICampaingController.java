package com.autowave.controller;

import com.autowave.dto.report.CampaignStatsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ICampaingController {
    public ResponseEntity<CampaignStatsDTO> getStats(@PathVariable Long id);
    public ResponseEntity<List<CampaignStatsDTO>> getAllStats(@RequestParam Long userId);
}
