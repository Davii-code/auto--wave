package com.autowave.entities;

import com.autowave.base.domain.GenericModel;
import com.autowave.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class Payment implements GenericModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;

    @Column(nullable = false, unique = true)
    private String mercadoPagoCheckoutId; // reference to Mercado Pago order

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status; // PENDING, PAID, FAILED

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private Integer attempt; // how many attempts were made to charge

    @Column(nullable = false, unique = true)
    private String correlationId; // for idempotency/log tracing
}
