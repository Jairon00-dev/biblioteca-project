package com.projeto.biblioteca.backend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmprestimoDTO {

    private String dataEmprestimo;
    private String dataDevolucao;
    private String status;
    private Long usuarioId;
    private Long livroId;
}