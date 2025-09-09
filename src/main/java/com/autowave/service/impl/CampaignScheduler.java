package com.autowave.service.impl;

import com.autowave.entities.Campaign;
import com.autowave.entities.Client;
import com.autowave.entities.Dispatch;
import com.autowave.repository.CampaignRepository;
import com.autowave.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CampaignScheduler {

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private DispatchService dispatchService;

    @Scheduled(cron = "0 0 2 * * *") // roda todo dia às 2h
    public void runDailyCampaigns() {
        List<Campaign> campaigns = campaignRepository.findAll(); // pode filtrar por ativas

        for (Campaign campaign : campaigns) {
            switch (campaign.getType()) {
                case BIRTHDAY -> processBirthdayCampaign(campaign);
                case INACTIVE -> processInactiveCampaign(campaign);
                case POST_SALE -> processPostSaleCampaign(campaign);
            }
        }
    }

    private void processBirthdayCampaign(Campaign campaign) {
        List<Client> clients = clientRepository.findByDateofbirth(LocalDate.now());
        createDispatches(campaign, clients);
    }

    private void processInactiveCampaign(Campaign campaign) {
        List<Client> clients = clientRepository.findByLastPurchaseBefore(LocalDate.now().minusDays(30));
        createDispatches(campaign, clients);
    }

    private void processPostSaleCampaign(Campaign campaign) {
        List<Client> clients = clientRepository.findByLastPurchase(LocalDate.now().minusDays(3));
        createDispatches(campaign, clients);
    }

    private void createDispatches(Campaign campaign, List<Client> clients) {
        for (Client client : clients) {
            Dispatch dispatch = new Dispatch();
            dispatch.setCampaign(campaign);
            dispatch.setClient(client);
            dispatchService.create(dispatch); // dispara e salva
        }
    }
}
