package com.autowave.dto.evolution;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvolutionWebhookDTO {
    private String event;
    private String id;
    private String remoteJid;
    private String text;
    private String timestamp;
}

