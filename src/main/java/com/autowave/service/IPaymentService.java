package com.autowave.service;

import com.autowave.base.service.IAbstractService;
import com.autowave.dto.request.PaymentRequestDTO;
import com.autowave.entities.Payment;

public interface IPaymentService extends IAbstractService<PaymentRequestDTO, Payment, Long> {
}
