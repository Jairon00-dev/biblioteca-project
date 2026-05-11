package biblioteca.backend.service;

import biblioteca.backend.domain.dto.LivroDTO;
import biblioteca.backend.domain.model.Livro;
import biblioteca.backend.repository.LivroRepository;
import biblioteca.backend.utils.MapperUtil;
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
    private AuditoriaService auditoriaService;

    public Livro save(Livro livro){

        boolean exists;

        if(livro.getId() == null){
            exists = repository.existsByTitulo(livro.getTitulo());
        } else {
            exists = repository.existsByTituloAndIdNot(livro.getTitulo(), livro.getId());
        }

        if(exists){
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Livro já cadastrado");
        }

        Livro livroSalvo = repository.save(livro);

        auditoriaService.registrar("Livro salvo: " + livro.getTitulo());

        return livroSalvo;
    }

    public List<LivroDTO> findAll(){
        return MapperUtil.parseListObjects(repository.findAll(), LivroDTO.class);
    }

    public LivroDTO findById(Long id){
        return MapperUtil.parseObject(repository.findById(id).orElseThrow(), LivroDTO.class);
    }

    public void delete(Long id){
        repository.deleteById(id);
        auditoriaService.registrar("Livro removido ID: " + id);
    }
}