package com.autowave.dto.evolution;

import com.autowave.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ClientSendMessageDTO {
    private List<Client> clients;
    private String message;
}
