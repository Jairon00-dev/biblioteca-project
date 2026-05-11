package biblioteca.backend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultaDTO {

    private Double valor;
    private String motivo;
    private String dataGeracao;
    private String statusPagamento;
}