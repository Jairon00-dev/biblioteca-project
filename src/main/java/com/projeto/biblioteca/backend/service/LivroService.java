package com.projeto.biblioteca.backend.service;

import com.projeto.biblioteca.backend.domain.dto.LivroDTO;
import com.projeto.biblioteca.backend.domain.model.Livro;
import com.projeto.biblioteca.backend.repository.CategoriaRepository;
import com.projeto.biblioteca.backend.repository.LivroRepository;
import com.projeto.biblioteca.backend.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private AuditoriaService auditoriaService;

    public Livro save(Livro livro){

        boolean exists;

        if(livro.getId() == null){
            exists = repository.existsByTitulo(livro.getTitulo());
        } else {
            exists = repository.existsByTituloAndIdNot(
                    livro.getTitulo(),
                    livro.getId()
            );
        }

        if(exists){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Livro já cadastrado"
            );
        }

        if(livro.getCategoria() == null ||
                livro.getCategoria().getId() == null){

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Categoria obrigatória"
            );
        }

        var categoria = categoriaRepository.findById(
                livro.getCategoria().getId()
        ).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Categoria não encontrada"
                )
        );

        livro.setCategoria(categoria);

        boolean isCreate = livro.getId() == null;

        Livro livroSalvo = repository.save(livro);

        auditoriaService.registrar(
                isCreate ? "CREATE" : "UPDATE",
                "Livro",
                "Livro salvo: " + livro.getTitulo()
        );

        return livroSalvo;
    }

    public List<LivroDTO> findAll(){
        return MapperUtil.parseListObjects(
                repository.findAll(),
                LivroDTO.class
        );
    }

    public LivroDTO findById(Long id){
        return MapperUtil.parseObject(
                repository.findById(id).orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Livro não encontrado"
                        )
                ),
                LivroDTO.class
        );
    }

    public void delete(Long id){

        repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Livro não encontrado"
                )
        );

        repository.deleteById(id);

        auditoriaService.registrar(
                "DELETE",
                "Livro",
                "Livro removido ID: " + id
        );
    }
}