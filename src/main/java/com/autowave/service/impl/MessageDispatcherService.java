package com.autowave.service.impl;

import com.autowave.dto.evolution.ClientSendMessageDTO;
import com.autowave.entities.Dispatch;
import com.autowave.repository.DispatchRepository;
import com.autowave.service.IEvolutionApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class MessageDispatcherService {

    @Autowired
    private DispatchRepository dispatchRepository;

    @Autowired
    private IEvolutionApiService evolutionService;

    @Scheduled(fixedDelay = 60000) // roda a cada 1 minuto
    public void processQueue() {
        List<Dispatch> batch = dispatchRepository.findTop20ByPendingTrueOrderByIdAsc();

        for (Dispatch dispatch : batch) {
            try {
                // Envia mensagem
                evolutionService.sendMessages(
                        new ClientSendMessageDTO(
                                List.of(dispatch.getClient()),
                                dispatch.getCampaign().getMessageTemplate()
                        )
                );

                // Marca como enviado
                dispatch.setPending(false);
                dispatch.setSentAt(LocalDateTime.now());
                dispatchRepository.save(dispatch);

                // Delay aleatório entre mensagens
                Thread.sleep(2000 + new Random().nextInt(3000));

            } catch (Exception e) {
                // opcional: logar erro e manter como pendente
                e.printStackTrace();
            }
        }
    }
}

