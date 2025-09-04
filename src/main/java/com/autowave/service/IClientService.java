package com.autowave.service;

import com.autowave.base.service.IAbstractService;
import com.autowave.dto.request.ClientRequestDTO;
import com.autowave.entities.Client;

public interface IClientService extends IAbstractService<ClientRequestDTO, Client, Long> {
}
