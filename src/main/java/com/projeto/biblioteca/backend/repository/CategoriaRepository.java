package com.projeto.biblioteca.backend.repository;

import com.projeto.biblioteca.backend.domain.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}