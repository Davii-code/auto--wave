package com.autowave.controller.impl;

import com.autowave.base.controller.impl.AbstractCrudController;
import com.autowave.controller.IPaymentController;
import com.autowave.dto.list.PaymentListDTO;
import com.autowave.dto.request.PaymentRequestDTO;
import com.autowave.dto.response.PaymentResponseDTO;
import com.autowave.entities.Payment;
import com.autowave.mapper.PaymentMapper;
import com.autowave.service.impl.PaymentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api.version}/payment")
public class PaymentController extends AbstractCrudController<PaymentRequestDTO, PaymentResponseDTO, PaymentListDTO, Payment, PaymentService, PaymentMapper, Long>
        implements IPaymentController {
}
