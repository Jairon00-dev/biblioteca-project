package com.projeto.biblioteca.backend.repository;

import com.projeto.biblioteca.backend.domain.model.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {
}