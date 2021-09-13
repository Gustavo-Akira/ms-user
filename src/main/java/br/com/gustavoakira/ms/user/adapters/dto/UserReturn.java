package br.com.gustavoakira.ms.user.adapters.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserReturn {
    private String name;
    private UUID userId;
}
