package com.autowave.service;

import com.autowave.dto.evolution.ConnectInstanceResponseDTO;
import com.autowave.dto.evolution.ConnectionStatusDTO;
import com.autowave.dto.evolution.ClientSendMessageDTO;
import com.autowave.dto.evolution.EvolutionWebhookDTO;

public interface IEvolutionApiService {
    Object apiInformation();
    void createInstance(Long userId, String instanceName);
    void deleteInstance(Long userId);
    ConnectInstanceResponseDTO connectInstance();
    void logoutInstance();
    ConnectionStatusDTO connectionStatus();
    void sendMessages(ClientSendMessageDTO dto);
    Boolean checkIsWhatsApp(String number);
    void processWebhook(EvolutionWebhookDTO event);
}
