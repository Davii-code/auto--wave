package com.autowave.controller.impl;

import com.autowave.base.controller.impl.AbstractCrudController;
import com.autowave.controller.IDispatchController;
import com.autowave.dto.list.DispatchListDTO;
import com.autowave.dto.request.DispatchRequestDTO;
import com.autowave.dto.response.DispatchResponseDTO;
import com.autowave.entities.Dispatch;
import com.autowave.mapper.DispatchMapper;
import com.autowave.service.impl.DispatchService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api.version}/dispatch")
public class DispatchController extends AbstractCrudController<
        DispatchRequestDTO,
        DispatchResponseDTO,
        DispatchListDTO,
        Dispatch,
        DispatchService,
        DispatchMapper,
        Long> implements IDispatchController {
}

