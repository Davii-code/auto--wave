package com.autowave.dto.list;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DispatchListDTO {
    private Long id;
    private String clientName;
    private String campaignName;
    private LocalDateTime sentAt;
    private Boolean delivered;
    private Boolean responded;
}
