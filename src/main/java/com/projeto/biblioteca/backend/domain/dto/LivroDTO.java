package biblioteca.backend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO {

    private String titulo;
    private String autor;
    private Integer anoPublicacao;
    private String genero;
    private Integer quantidadeDisponivel;
}