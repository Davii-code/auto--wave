package com.autowave.dto.evolution;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CreateInstanceRequestDTO {
    private String instanceName;
    private Boolean qrcode;
    private String integration;
}
