package com.autowave.dto.list;

import com.autowave.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentListDTO {
    private Long id;
    private PaymentStatus status;
    private BigDecimal amount;
    private LocalDateTime createdAt;
}