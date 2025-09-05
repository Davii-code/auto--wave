package com.autowave.service;

import com.autowave.base.service.IAbstractService;
import com.autowave.dto.request.PaymentRequestDTO;
import com.autowave.dto.request.SubscriptionRequestDTO;
import com.autowave.entities.Payment;
import com.autowave.entities.Subscription;

public interface ISubscriptionService extends IAbstractService<SubscriptionRequestDTO, Subscription, Long> {
}
