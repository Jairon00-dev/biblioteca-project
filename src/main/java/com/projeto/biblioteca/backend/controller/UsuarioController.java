package com.projeto.biblioteca.backend.controller;

import com.projeto.biblioteca.backend.domain.dto.UsuarioDTO;
import com.projeto.biblioteca.backend.domain.model.Usuario;
import com.projeto.biblioteca.backend.service.UsuarioService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public Usuario save(@RequestBody Usuario usuario){
        return service.save(usuario);
    }

    @PutMapping
    public Usuario update(@RequestBody Usuario usuario){
        return service.save(usuario);
    }

    @GetMapping
    public List<UsuarioDTO> findAll(){
        return service.findAll();
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Usuário encontrado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Usuário não encontrado"
            )
    })

    @GetMapping("/{id}")
    public UsuarioDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}