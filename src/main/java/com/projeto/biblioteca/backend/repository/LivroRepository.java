package com.projeto.biblioteca.backend.repository;

import com.projeto.biblioteca.backend.domain.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    boolean existsByTitulo(String titulo);

    boolean existsByTituloAndIdNot(String titulo, Long id);
}