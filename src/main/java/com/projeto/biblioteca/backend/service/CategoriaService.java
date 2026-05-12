package com.projeto.biblioteca.backend.service;

import com.projeto.biblioteca.backend.domain.dto.CategoriaDTO;
import com.projeto.biblioteca.backend.domain.model.Categoria;
import com.projeto.biblioteca.backend.repository.CategoriaRepository;
import com.projeto.biblioteca.backend.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria save(Categoria categoria){
        return repository.save(categoria);
    }

    public List<CategoriaDTO> findAll(){
        return MapperUtil.parseListObjects(repository.findAll(), CategoriaDTO.class);
    }

    public CategoriaDTO findById(Long id){
        return MapperUtil.parseObject(repository.findById(id).orElseThrow(), CategoriaDTO.class);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}