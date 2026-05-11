package biblioteca.backend.service;

import biblioteca.backend.domain.dto.EmprestimoDTO;
import biblioteca.backend.domain.model.Emprestimo;
import biblioteca.backend.repository.EmprestimoRepository;
import biblioteca.backend.utils.MapperUtil;
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

        auditoriaService.registrar("Empréstimo realizado ID: " + salvo.getId());

        return salvo;
    }

    public List<EmprestimoDTO> findAll(){
        return MapperUtil.parseListObjects(repository.findAll(), EmprestimoDTO.class);
    }

    public EmprestimoDTO findById(Long id){
        return MapperUtil.parseObject(repository.findById(id).orElseThrow(), EmprestimoDTO.class);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}