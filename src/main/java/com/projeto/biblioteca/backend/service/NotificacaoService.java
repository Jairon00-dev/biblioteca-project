package com.projeto.biblioteca.backend.service;

import com.projeto.biblioteca.backend.domain.dto.NotificacaoDTO;
import com.projeto.biblioteca.backend.domain.model.Notificacao;
import com.projeto.biblioteca.backend.repository.NotificacaoRepository;
import com.projeto.biblioteca.backend.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository repository;

    @Autowired
    private AuditoriaService auditoriaService;

    public Notificacao save(Notificacao notificacao){

        notificacao.setDataEnvio(LocalDateTime.now());

        Notificacao salva = repository.save(notificacao);

        auditoriaService.registrar(
                "CREATE",
                "Notificacao",
                "Notificação criada"
        );

        return salva;
    }

    public List<NotificacaoDTO> findAll(){
        return MapperUtil.parseListObjects(
                repository.findAll(),
                NotificacaoDTO.class
        );
    }

    public NotificacaoDTO findById(Long id){
        return MapperUtil.parseObject(
                repository.findById(id).orElseThrow(),
                NotificacaoDTO.class
        );
    }

    public void delete(Long id){

        repository.deleteById(id);

        auditoriaService.registrar(
                "DELETE",
                "Notificacao",
                "Notificação removida ID: " + id
        );
    }
}