package com.projeto.biblioteca.backend.domain.dto;

import lombok.Data;

@Data
public class UsuarioDTO {

    private Long id;

    private String nome;

    private String email;

    private String perfil;
}