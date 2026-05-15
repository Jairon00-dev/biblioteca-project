package com.projeto.biblioteca.backend.controller;

import com.projeto.biblioteca.backend.domain.dto.CategoriaDTO;
import com.projeto.biblioteca.backend.domain.model.Categoria;
import com.projeto.biblioteca.backend.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @PostMapping
    public Categoria save(@RequestBody Categoria categoria){
        return service.save(categoria);
    }

    @GetMapping
    public List<CategoriaDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CategoriaDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}