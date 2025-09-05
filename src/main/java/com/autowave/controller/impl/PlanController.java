package com.autowave.controller.impl;

import com.autowave.base.controller.impl.AbstractCrudController;
import com.autowave.controller.IPlanController;
import com.autowave.dto.list.PlanListDTO;
import com.autowave.dto.request.PlanRequestDTO;
import com.autowave.dto.response.PlanResponseDTO;
import com.autowave.entities.Plan;
import com.autowave.mapper.PlanMapper;
import com.autowave.service.impl.PlanService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api.version}/plan")
public class PlanController extends AbstractCrudController<PlanRequestDTO, PlanResponseDTO, PlanListDTO, Plan, PlanService, PlanMapper, Long>
        implements IPlanController {
}
