package com.projeto.biblioteca.backend.service;

import com.projeto.biblioteca.backend.domain.dto.EmprestimoDTO;
import com.projeto.biblioteca.backend.domain.model.Emprestimo;
import com.projeto.biblioteca.backend.repository.EmprestimoRepository;
import com.projeto.biblioteca.backend.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository repository;

    @Autowired
    private AuditoriaService auditoriaService;

    public Emprestimo save(Emprestimo emprestimo){

        Emprestimo salvo = repository.save(emprestimo);

        auditoriaService.registrar(
                "CREATE",
                "Emprestimo",
                "Empréstimo realizado ID: " + salvo.getId()
        );

        return salvo;
    }

    public List<EmprestimoDTO> findAll(){
        return MapperUtil.parseListObjects(repository.findAll(), EmprestimoDTO.class);
    }

    public EmprestimoDTO findById(Long id){
        return MapperUtil.parseObject(
                repository.findById(id).orElseThrow(),
                EmprestimoDTO.class
        );
    }

    public void delete(Long id){

        repository.deleteById(id);

        auditoriaService.registrar(
                "DELETE",
                "Emprestimo",
                "Empréstimo removido ID: " + id
        );
    }
}