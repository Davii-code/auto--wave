package com.autowave.service.impl;

import com.autowave.base.service.impl.AbstractService;
import com.autowave.dto.list.ClientListDTO;
import com.autowave.dto.request.ClientRequestDTO;
import com.autowave.dto.response.ClientResponseDTO;
import com.autowave.entities.Client;
import com.autowave.mapper.ClientMapper;
import com.autowave.repository.ClientRepository;
import com.autowave.service.IClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends AbstractService<ClientRequestDTO, ClientResponseDTO, ClientListDTO, Client, ClientRepository, ClientMapper, Long>
        implements IClientService {
    @Override
    protected void prepareToCreate(Client data) {

    }

    @Override
    protected void prepareToUpdate(Client dataDB) {

    }

    @Override
    protected void prepareToDelete(Client dataDB) {

    }
}