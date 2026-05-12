package com.projeto.biblioteca.backend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {

    private String nome;
    private String descricao;
    private String codigo;
    private Boolean ativo;
}