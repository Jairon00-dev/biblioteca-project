package com.projeto.biblioteca.backend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificacaoDTO {

    private Long id;

    private String mensagem;

    private String tipo;

    private LocalDateTime dataEnvio;
}