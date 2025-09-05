package com.autowave.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionRequestDTO {
    private UserRequestClientDTO user;
    private PlanRequestDTO plan;
}