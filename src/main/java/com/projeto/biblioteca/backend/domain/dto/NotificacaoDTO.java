package biblioteca.backend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificacaoDTO {

    private String mensagem;
    private String dataEnvio;
    private String tipo;
    private String destinatario;
}