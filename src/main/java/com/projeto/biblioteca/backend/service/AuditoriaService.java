package biblioteca.backend.service;

import org.springframework.stereotype.Service;

@Service
public class AuditoriaService {

    public void registrar(String mensagem){
        System.out.println("AUDITORIA: " + mensagem);
    }
}