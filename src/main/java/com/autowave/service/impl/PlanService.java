package com.autowave.service.impl;

import com.autowave.base.service.impl.AbstractService;
import com.autowave.dto.list.PlanListDTO;
import com.autowave.dto.request.PlanRequestDTO;
import com.autowave.dto.response.PlanResponseDTO;
import com.autowave.entities.Plan;
import com.autowave.mapper.PlanMapper;
import com.autowave.repository.PlanRepository;
import com.autowave.service.IPlanService;
import org.springframework.stereotype.Service;

@Service
public class PlanService extends AbstractService<PlanRequestDTO, PlanResponseDTO, PlanListDTO, Plan, PlanRepository, PlanMapper, Long>
        implements IPlanService {

    @Override
    protected void prepareToCreate(Plan data) {

    }

    @Override
    protected void prepareToUpdate(Plan dataDB) {

    }

    @Override
    protected void prepareToDelete(Plan dataDB) {

    }
}