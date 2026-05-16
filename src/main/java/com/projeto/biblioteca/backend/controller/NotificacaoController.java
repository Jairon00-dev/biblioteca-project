package com.projeto.biblioteca.backend.controller;

import com.projeto.biblioteca.backend.domain.dto.NotificacaoDTO;
import com.projeto.biblioteca.backend.domain.model.Notificacao;
import com.projeto.biblioteca.backend.service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notificacao")
public class NotificacaoController {

    @Autowired
    private NotificacaoService service;

    @PostMapping
    public Notificacao save(@RequestBody Notificacao notificacao){
        return service.save(notificacao);
    }

    @GetMapping
    public List<NotificacaoDTO> findAll(){
        return service.findAll();
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Notificação encontrada com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Notificação não encontrada"
            )
    })

    @GetMapping("/{id}")
    public NotificacaoDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}