package com.autowave.dto.list;

import com.autowave.enums.SubscriptionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionListDTO {
    private Long id;
    private SubscriptionStatus status;
    private LocalDate expirationDate;
}
