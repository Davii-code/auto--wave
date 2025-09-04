package com.autowave.service;

import com.autowave.base.service.IAbstractService;
import com.autowave.dto.request.ClientRequestDTO;
import com.autowave.dto.request.DispatchRequestDTO;
import com.autowave.entities.Client;
import com.autowave.entities.Dispatch;

public interface IDispatchService extends IAbstractService<DispatchRequestDTO, Dispatch, Long> {
}
