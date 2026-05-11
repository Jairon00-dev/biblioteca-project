package biblioteca.backend.controller;

import biblioteca.backend.domain.dto.MultaDTO;
import biblioteca.backend.domain.model.Multa;
import biblioteca.backend.service.MultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/multa")
public class MultaController {

    @Autowired
    private MultaService service;

    @PostMapping
    public Multa create(@RequestBody Multa multa){
        return service.save(multa);
    }

    @PutMapping
    public Multa update(@RequestBody Multa multa){
        return service.save(multa);
    }

    @GetMapping
    public List<MultaDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public MultaDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}