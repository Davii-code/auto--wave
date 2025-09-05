package com.autowave.service.impl;

import com.autowave.base.service.impl.AbstractService;
import com.autowave.dto.list.PaymentListDTO;
import com.autowave.dto.list.SubscriptionListDTO;
import com.autowave.dto.request.PaymentRequestDTO;
import com.autowave.dto.request.SubscriptionRequestDTO;
import com.autowave.dto.response.PaymentResponseDTO;
import com.autowave.dto.response.SubscriptionResponseDTO;
import com.autowave.entities.Payment;
import com.autowave.entities.Subscription;
import com.autowave.mapper.PaymentMapper;
import com.autowave.mapper.SubscriptionMapper;
import com.autowave.repository.PaymentRepository;
import com.autowave.repository.SubscriptionRepository;
import com.autowave.service.IPaymentService;
import com.autowave.service.ISubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService extends AbstractService<SubscriptionRequestDTO, SubscriptionResponseDTO, SubscriptionListDTO, Subscription, SubscriptionRepository, SubscriptionMapper, Long>
        implements ISubscriptionService {

    @Override
    protected void prepareToCreate(Subscription data) {

    }

    @Override
    protected void prepareToUpdate(Subscription dataDB) {

    }

    @Override
    protected void prepareToDelete(Subscription dataDB) {

    }
}