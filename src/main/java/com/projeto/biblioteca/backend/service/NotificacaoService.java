package com.projeto.biblioteca.backend.service;

import com.projeto.biblioteca.backend.domain.dto.NotificacaoDTO;
import com.projeto.biblioteca.backend.domain.model.Notificacao;
import com.projeto.biblioteca.backend.repository.NotificacaoRepository;
import com.projeto.biblioteca.backend.repository.UsuarioRepository;
import com.projeto.biblioteca.backend.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AuditoriaService auditoriaService;

    public Notificacao save(Notificacao notificacao){

        if(notificacao.getUsuario() == null ||
                notificacao.getUsuario().getId() == null){

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Usuário obrigatório"
            );
        }

        var usuario = usuarioRepository.findById(
                notificacao.getUsuario().getId()
        ).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Usuário não encontrado"
                )
        );

        notificacao.setUsuario(usuario);

        notificacao.setDataEnvio(LocalDateTime.now());

        boolean isCreate = notificacao.getId() == null;

        Notificacao salva = repository.save(notificacao);

        auditoriaService.registrar(
                isCreate ? "CREATE" : "UPDATE",
                "Notificacao",
                "Notificação salva"
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
                repository.findById(id).orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Notificação não encontrada"
                        )
                ),
                NotificacaoDTO.class
        );
    }

    public void delete(Long id){

        repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Notificação não encontrada"
                )
        );

        repository.deleteById(id);

        auditoriaService.registrar(
                "DELETE",
                "Notificacao",
                "Notificação removida ID: " + id
        );
    }
}