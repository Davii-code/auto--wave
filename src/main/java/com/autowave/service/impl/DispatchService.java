package com.autowave.service.impl;

import com.autowave.base.service.impl.AbstractService;
import com.autowave.dto.evolution.ClientSendMessageDTO;
import com.autowave.dto.evolution.EvolutionSendMessageDTO;
import com.autowave.dto.list.DispatchListDTO;
import com.autowave.dto.request.DispatchRequestDTO;
import com.autowave.dto.response.DispatchResponseDTO;
import com.autowave.entities.Dispatch;
import com.autowave.mapper.DispatchMapper;
import com.autowave.repository.DispatchRepository;
import com.autowave.service.IDispatchService;
import com.autowave.service.IEvolutionApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DispatchService extends AbstractService<
        DispatchRequestDTO,
        DispatchResponseDTO,
        DispatchListDTO,
        Dispatch,
        DispatchRepository,
        DispatchMapper,
        Long> implements IDispatchService {

    @Autowired
    protected IEvolutionApiService service;

    @Override
    protected void prepareToCreate(Dispatch data) {

        ClientSendMessageDTO dto = new ClientSendMessageDTO();
        dto.setMessage(data.getCampaign().getMessageTemplate());
        dto.setClients(List.of(data.getClient()));

        service.sendMessages(dto);

        data.setSentAt(LocalDateTime.now());
        data.setDelivered(false);
        data.setResponded(false);

    }

    @Override
    protected void prepareToUpdate(Dispatch dataDB) {
    }

    @Override
    protected void prepareToDelete(Dispatch dataDB) {
    }
}
