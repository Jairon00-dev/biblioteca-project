package com.projeto.biblioteca.backend.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String setor;

    private String observacao;

    // IGNORA A LISTA DE LIVROS NO JSON EVITANDO LOOP INFINITO

    @JsonIgnore
    @OneToMany(mappedBy = "categoria")
    private List<Livro> livros;
}