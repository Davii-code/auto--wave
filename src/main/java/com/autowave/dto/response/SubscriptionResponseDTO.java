package com.autowave.dto.response;

import com.autowave.dto.request.PlanRequestDTO;
import com.autowave.dto.request.UserRequestClientDTO;
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
public class SubscriptionResponseDTO {
    private Long id;
    private UserRequestClientDTO user;
    private PlanRequestDTO plan;
    private SubscriptionStatus status;
    private LocalDate startDate;
    private LocalDate expirationDate;
    private LocalDate nextBillingDate;
}