package com.projeto.biblioteca.backend.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String titulo;

    private String autor;

    private Integer quantidadeDisponivel;

    // RELACIONA O LIVRO A CATEGORIA CADASTRADA NO SISTEMA

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}