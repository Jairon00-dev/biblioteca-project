package biblioteca.backend.controller;

import biblioteca.backend.domain.dto.NotificacaoDTO;
import biblioteca.backend.domain.model.Notificacao;
import biblioteca.backend.service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notificacao")
public class NotificacaoController {

    @Autowired
    private NotificacaoService service;

    @PostMapping
    public Notificacao create(@RequestBody Notificacao notificacao){
        return service.save(notificacao);
    }

    @PutMapping
    public Notificacao update(@RequestBody Notificacao notificacao){
        return service.save(notificacao);
    }

    @GetMapping
    public List<NotificacaoDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public NotificacaoDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}