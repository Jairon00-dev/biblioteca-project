package biblioteca.backend.controller;

import biblioteca.backend.domain.dto.EmprestimoDTO;
import biblioteca.backend.domain.model.Emprestimo;
import biblioteca.backend.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public EmprestimoDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}