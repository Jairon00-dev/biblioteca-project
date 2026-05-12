package com.projeto.biblioteca.backend.controller;

import com.projeto.biblioteca.backend.domain.dto.UsuarioDTO;
import com.projeto.biblioteca.backend.domain.model.Usuario;
import com.projeto.biblioteca.backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public Usuario save(@RequestBody Usuario usuario){
        return service.save(usuario);
    }

    @GetMapping
    public List<UsuarioDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public UsuarioDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}