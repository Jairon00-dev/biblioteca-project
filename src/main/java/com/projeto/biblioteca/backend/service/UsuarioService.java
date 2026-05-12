package com.projeto.biblioteca.backend.service;

import com.projeto.biblioteca.backend.domain.dto.UsuarioDTO;
import com.projeto.biblioteca.backend.domain.model.Usuario;
import com.projeto.biblioteca.backend.repository.UsuarioRepository;
import com.projeto.biblioteca.backend.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private AuditoriaService auditoriaService;

    public Usuario save(Usuario usuario){

        Usuario salvo = repository.save(usuario);

        auditoriaService.registrar(
                "CREATE",
                "Usuario",
                "Usuário criado: " + usuario.getNome()
        );

        return salvo;
    }

    public List<UsuarioDTO> findAll(){
        return MapperUtil.parseListObjects(repository.findAll(), UsuarioDTO.class);
    }

    public UsuarioDTO findById(Long id){
        return MapperUtil.parseObject(
                repository.findById(id).orElseThrow(),
                UsuarioDTO.class
        );
    }

    public void delete(Long id){

        repository.deleteById(id);

        auditoriaService.registrar(
                "DELETE",
                "Usuario",
                "Usuário removido ID: " + id
        );
    }
}