package com.projeto.biblioteca.backend.service;

import com.projeto.biblioteca.backend.domain.dto.NotificacaoDTO;
import com.projeto.biblioteca.backend.domain.model.Notificacao;
import com.projeto.biblioteca.backend.repository.NotificacaoRepository;
import com.projeto.biblioteca.backend.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository repository;

    public Notificacao save(Notificacao notificacao){
        return repository.save(notificacao);
    }

    public List<NotificacaoDTO> findAll(){
        return MapperUtil.parseListObjects(repository.findAll(), NotificacaoDTO.class);
    }

    public NotificacaoDTO findById(Long id){
        return MapperUtil.parseObject(repository.findById(id).orElseThrow(), NotificacaoDTO.class);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}