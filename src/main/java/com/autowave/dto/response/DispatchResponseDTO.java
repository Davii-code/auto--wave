package com.autowave.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DispatchResponseDTO {
    private Long id;
    private Long campaignId;
    private Long clientId;
    private LocalDateTime sentAt;
    private Boolean delivered;
    private Boolean responded;
}
