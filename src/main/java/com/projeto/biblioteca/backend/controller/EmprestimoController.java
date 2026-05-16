package com.projeto.biblioteca.backend.controller;

import com.projeto.biblioteca.backend.domain.dto.EmprestimoDTO;
import com.projeto.biblioteca.backend.domain.model.Emprestimo;
import com.projeto.biblioteca.backend.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/api/v1/emprestimo")
public class EmprestimoController {

    @Autowired
    private EmprestimoService service;

    @PostMapping
    public Emprestimo create(@RequestBody Emprestimo emprestimo){
        return service.save(emprestimo);
    }

    @PutMapping
    public Emprestimo update(@RequestBody Emprestimo emprestimo){
        return service.save(emprestimo);
    }

    @GetMapping
    public List<EmprestimoDTO> findAll(){
        return service.findAll();
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Empréstimo encontrado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Empréstimo não encontrado"
            )
    })

    @GetMapping("/{id}")
    public EmprestimoDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}