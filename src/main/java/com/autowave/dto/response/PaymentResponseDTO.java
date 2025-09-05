package com.autowave.dto.response;

import com.autowave.dto.request.SubscriptionRequestDTO;
import com.autowave.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponseDTO {
    private Long id;
    private SubscriptionRequestDTO subscription;
    private String mercadoPagoCheckoutId;
    private PaymentStatus status;
    private BigDecimal amount;
    private Integer attempt;
    private String correlationId;
}