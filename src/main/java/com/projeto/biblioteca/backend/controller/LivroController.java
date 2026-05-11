package biblioteca.backend.controller;

import biblioteca.backend.domain.dto.LivroDTO;
import biblioteca.backend.domain.model.Livro;
import biblioteca.backend.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/livro")
public class LivroController {

    @Autowired
    private LivroService service;

    @PostMapping
    public Livro create(@RequestBody Livro livro){
        return service.save(livro);
    }

    @PutMapping
    public Livro update(@RequestBody Livro livro){
        return service.save(livro);
    }

    @GetMapping
    public List<LivroDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public LivroDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}