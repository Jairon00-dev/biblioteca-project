package com.projeto.biblioteca.backend.service;

import com.projeto.biblioteca.backend.domain.dto.EmprestimoDTO;
import com.projeto.biblioteca.backend.domain.model.Emprestimo;
import com.projeto.biblioteca.backend.repository.EmprestimoRepository;
import com.projeto.biblioteca.backend.repository.LivroRepository;
import com.projeto.biblioteca.backend.repository.UsuarioRepository;
import com.projeto.biblioteca.backend.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AuditoriaService auditoriaService;

    public Emprestimo save(Emprestimo emprestimo){

        if(emprestimo.getUsuario() == null ||
                emprestimo.getUsuario().getId() == null){

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Usuário obrigatório"
            );
        }

        if(emprestimo.getLivro() == null ||
                emprestimo.getLivro().getId() == null){

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Livro obrigatório"
            );
        }

        var usuario = usuarioRepository.findById(
                emprestimo.getUsuario().getId()
        ).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Usuário não encontrado"
                )
        );

        var livro = livroRepository.findById(
                emprestimo.getLivro().getId()
        ).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Livro não encontrado"
                )
        );

        emprestimo.setUsuario(usuario);
        emprestimo.setLivro(livro);

        boolean isCreate = emprestimo.getId() == null;

        Emprestimo salvo = repository.save(emprestimo);

        auditoriaService.registrar(
                isCreate ? "CREATE" : "UPDATE",
                "Emprestimo",
                "Empréstimo salvo ID: " + salvo.getId()
        );

        return salvo;
    }

    public List<EmprestimoDTO> findAll(){
        return MapperUtil.parseListObjects(
                repository.findAll(),
                EmprestimoDTO.class
        );
    }

    public EmprestimoDTO findById(Long id){
        return MapperUtil.parseObject(
                repository.findById(id).orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Empréstimo não encontrado"
                        )
                ),
                EmprestimoDTO.class
        );
    }

    public void delete(Long id){

        repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Empréstimo não encontrado"
                )
        );

        repository.deleteById(id);

        auditoriaService.registrar(
                "DELETE",
                "Emprestimo",
                "Empréstimo removido ID: " + id
        );
    }
}