package com.autowave.service.impl;

import com.autowave.base.service.impl.AbstractService;
import com.autowave.dto.list.DispatchListDTO;
import com.autowave.dto.request.DispatchRequestDTO;
import com.autowave.dto.response.DispatchResponseDTO;
import com.autowave.entities.Dispatch;
import com.autowave.mapper.DispatchMapper;
import com.autowave.repository.DispatchRepository;
import com.autowave.service.IDispatchService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DispatchService extends AbstractService<
        DispatchRequestDTO,
        DispatchResponseDTO,
        DispatchListDTO,
        Dispatch,
        DispatchRepository,
        DispatchMapper,
        Long> implements IDispatchService {

    @Override
    protected void prepareToCreate(Dispatch data) {
    }

    @Override
    protected void prepareToUpdate(Dispatch dataDB) {
    }

    @Override
    protected void prepareToDelete(Dispatch dataDB) {
    }
}
