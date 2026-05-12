package com.projeto.biblioteca.backend.service;

import com.projeto.biblioteca.backend.domain.model.Auditoria;
import com.projeto.biblioteca.backend.repository.AuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditoriaService {

    @Autowired
    private AuditoriaRepository repository;

    public void registrar(String acao, String entidade, String descricao) {

        Auditoria auditoria = new Auditoria();
        auditoria.setAcao(acao);
        auditoria.setEntidade(entidade);
        auditoria.setDescricao(descricao);
        auditoria.setData(LocalDateTime.now());

        repository.save(auditoria);
    }
}