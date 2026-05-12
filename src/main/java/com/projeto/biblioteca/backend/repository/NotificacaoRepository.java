package com.projeto.biblioteca.backend.repository;

import com.projeto.biblioteca.backend.domain.model.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {
}