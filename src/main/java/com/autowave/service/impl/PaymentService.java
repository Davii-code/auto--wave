package com.autowave.service.impl;

import com.autowave.base.service.impl.AbstractService;
import com.autowave.dto.list.PaymentListDTO;
import com.autowave.dto.list.PlanListDTO;
import com.autowave.dto.request.PaymentRequestDTO;
import com.autowave.dto.request.PlanRequestDTO;
import com.autowave.dto.response.PaymentResponseDTO;
import com.autowave.dto.response.PlanResponseDTO;
import com.autowave.entities.Payment;
import com.autowave.entities.Plan;
import com.autowave.mapper.PaymentMapper;
import com.autowave.mapper.PlanMapper;
import com.autowave.repository.PaymentRepository;
import com.autowave.repository.PlanRepository;
import com.autowave.service.IPaymentService;
import com.autowave.service.IPlanService;
import org.springframework.stereotype.Service;

@Service
public class PaymentService extends AbstractService<PaymentRequestDTO, PaymentResponseDTO, PaymentListDTO, Payment, PaymentRepository, PaymentMapper, Long>
        implements IPaymentService {

    @Override
    protected void prepareToCreate(Payment data) {

    }

    @Override
    protected void prepareToUpdate(Payment dataDB) {

    }

    @Override
    protected void prepareToDelete(Payment dataDB) {

    }
}