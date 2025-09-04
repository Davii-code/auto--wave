package com.autowave.controller.impl;

import com.autowave.base.controller.impl.AbstractCrudController;
import com.autowave.controller.IClientController;
import com.autowave.dto.list.ClientListDTO;
import com.autowave.dto.request.ClientRequestDTO;
import com.autowave.dto.response.ClientResponseDTO;
import com.autowave.entities.Client;
import com.autowave.mapper.ClientMapper;
import com.autowave.service.impl.ClientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api.version}/client")
public class ClientController extends AbstractCrudController<
        ClientRequestDTO,
        ClientResponseDTO,
        ClientListDTO,
        Client,
        ClientService,
        ClientMapper,
        Long> implements IClientController {
}
