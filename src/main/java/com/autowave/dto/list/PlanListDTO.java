package com.autowave.dto.list;

import com.autowave.enums.BillingPeriod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PlanListDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private BillingPeriod billingPeriod;
}
