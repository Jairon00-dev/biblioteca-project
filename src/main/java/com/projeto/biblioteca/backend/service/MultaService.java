package biblioteca.backend.service;

import biblioteca.backend.domain.dto.MultaDTO;
import biblioteca.backend.domain.model.Multa;
import biblioteca.backend.repository.MultaRepository;
import biblioteca.backend.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultaService {

    @Autowired
    private MultaRepository repository;

    public Multa save(Multa multa){
        return repository.save(multa);
    }

    public List<MultaDTO> findAll(){
        return MapperUtil.parseListObjects(repository.findAll(), MultaDTO.class);
    }

    public MultaDTO findById(Long id){
        return MapperUtil.parseObject(repository.findById(id).orElseThrow(), MultaDTO.class);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}