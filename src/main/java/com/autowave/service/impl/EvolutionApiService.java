package com.autowave.service.impl;

import com.autowave.base.exception.BusinessException;
import com.autowave.client.EvolutionApiClient;
import com.autowave.dto.evolution.*;
import com.autowave.entities.Client;
import com.autowave.entities.Dispatch;
import com.autowave.entities.EvolutionInstance;
import com.autowave.entities.User;
import com.autowave.enums.ErrorEnum;
import com.autowave.repository.DispatchRepository;
import com.autowave.service.IEvolutionApiService;
import com.autowave.service.IUserService;
import com.autowave.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class EvolutionApiService implements IEvolutionApiService {

    @Autowired
    private EvolutionApiClient client;

    @Autowired
    private IUserService userService;

    @Value("${globalApikey_evolutionapi}")
    private String globalApiKey;

    @Value("${integration_evolutionapi}")
    private String integration;

    private DispatchRepository dispatchRepository;


    @Override
    public Object apiInformation() {
        return client.apiInformation();
    }

    @Override
    public void createInstance(Long userId, String instanceName) {
        if (!this.instanceIsValid(userService.getEvolutionInstanceByUserId(userId))) {
            CreateInstanceRequestDTO requestDTO = new CreateInstanceRequestDTO();
            requestDTO.setInstanceName(instanceName);
            requestDTO.setQrcode(false);
            requestDTO.setIntegration(integration);
            CreateInstanceResponseDTO response = client.createInstance(globalApiKey, requestDTO);

            User user = userService.getById(userId);
            user.setApiKeyEvolution(response.getInstance_hash());
            user.setInstanceNameEvolution(response.getInstance_name());
        } else {
            throw new BusinessException(ErrorEnum.USER_HASH_INSTANCE);
        }
    }

    @Override
    public void deleteInstance(Long userId) {
        EvolutionInstance instance = userService.getEvolutionInstanceByUserId(userId);
        if (instance == null || (Util.isNullOrEmpty(instance.getInstanceName()) && Util.isNullOrEmpty(instance.getInstanceApiKey()))) {
            throw new BusinessException(ErrorEnum.USER_NOT_HAVE_INSTANCE);
        }
        client.deleteInstance(globalApiKey, instance.getInstanceName());

        User user = userService.getById(Util.getIdUserLogged());
        user.setApiKeyEvolution(null);
        user.setInstanceNameEvolution(null);
    }

    @Override
    public ConnectInstanceResponseDTO connectInstance() {
        EvolutionInstance instance = userService.getEvolutionInstanceByUserId(Util.getIdUserLogged());
        if (instance == null || (Util.isNullOrEmpty(instance.getInstanceName()) && Util.isNullOrEmpty(instance.getInstanceApiKey()))) {
            throw new BusinessException(ErrorEnum.YOU_NOT_HAVE_INSTANCE);
        }
        return client.connectInstance(instance.getInstanceApiKey(), instance.getInstanceName());
    }

    @Override
    public void logoutInstance() {
        EvolutionInstance instance = userService.getEvolutionInstanceByUserId(Util.getIdUserLogged());
        if (instance == null || (Util.isNullOrEmpty(instance.getInstanceName()) && Util.isNullOrEmpty(instance.getInstanceApiKey()))) {
            throw new BusinessException(ErrorEnum.YOU_NOT_HAVE_INSTANCE);
        }
        client.logoutInstance(instance.getInstanceApiKey(), instance.getInstanceName());
    }

    @Override
    public ConnectionStatusDTO connectionStatus() {
        EvolutionInstance instance = userService.getEvolutionInstanceByUserId(Util.getIdUserLogged());
        if (instance == null || (Util.isNullOrEmpty(instance.getInstanceName()) && Util.isNullOrEmpty(instance.getInstanceApiKey()))) {
            throw new BusinessException(ErrorEnum.YOU_NOT_HAVE_INSTANCE);
        }
        return client.connectionStatus(instance.getInstanceApiKey(), instance.getInstanceName());
    }

    public Boolean instanceIsValid(EvolutionInstance instance) {
        return instance != null && !Util.isNullOrEmpty(instance.getInstanceName()) && !Util.isNullOrEmpty(instance.getInstanceApiKey());
    }

    public void sendMessages(ClientSendMessageDTO dto) {
        EvolutionInstance instance = userService.getEvolutionInstanceByUserId(Util.getIdUserLogged());

        if (instance == null || Util.isNullOrEmpty(instance.getInstanceName()) || Util.isNullOrEmpty(instance.getInstanceApiKey())) {
            throw new BusinessException(ErrorEnum.YOU_NOT_HAVE_INSTANCE);
        }

        for (Client client1 : dto.getClients()) {
            client.sendMessage(instance.getInstanceApiKey(), instance.getInstanceName(), new EvolutionSendMessageDTO("55"+client1.getTelephone(), dto.getMessage()));
        }
    }

    public Boolean checkIsWhatsApp(String number) {
        EvolutionInstance instance = userService.getEvolutionInstanceByUserId(Util.getIdUserLogged());

        if (instance == null || Util.isNullOrEmpty(instance.getInstanceName()) || Util.isNullOrEmpty(instance.getInstanceApiKey())) {
            throw new BusinessException(ErrorEnum.YOU_NOT_HAVE_INSTANCE);
        }

        Map<String, Object> payload = new HashMap<>();
        payload.put("number", number);

        Object response = client.checkIsWhatsApp(instance.getInstanceApiKey(), payload);

        return response instanceof Boolean && (Boolean) response; // para evitar nulos
    }


    public void processWebhook(EvolutionWebhookDTO event) {
        String phone = event.getRemoteJid().replace("@s.whatsapp.net", "");

        // Localiza último dispatch para esse cliente
        Optional<Dispatch> dispatchOpt = dispatchRepository
                .findTopByClientTelephoneOrderBySentAtDesc(phone);

        if (dispatchOpt.isPresent()) {
            Dispatch dispatch = dispatchOpt.get();

            switch (event.getEvent()) {
                case "message_delivered" -> dispatch.setDelivered(true);
                case "message_read" -> dispatch.setDelivered(true); // ou criar campo readAt se quiser
                case "message_received" -> {
                    dispatch.setResponded(true);
                    dispatch.setSentAt(LocalDateTime.now());
                }
            }

            dispatchRepository.save(dispatch);
        }
    }

}
