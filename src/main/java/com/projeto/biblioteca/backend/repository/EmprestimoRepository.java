package com.projeto.biblioteca.backend.repository;

import com.projeto.biblioteca.backend.domain.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}