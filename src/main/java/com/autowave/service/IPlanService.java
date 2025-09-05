package com.autowave.service;

import com.autowave.base.service.IAbstractService;
import com.autowave.dto.request.PlanRequestDTO;
import com.autowave.entities.Plan;

public interface IPlanService extends IAbstractService<PlanRequestDTO, Plan, Long> {
}
