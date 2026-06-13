package estg.ipvc.proj2.dtos.cateringdto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CateringDto {

    private Integer id;
    private Integer nhospedes;
    private BigDecimal precohosp;

    /**FK para Servico (obrigatório na tua nova modelação 1:N) */
    private Integer idServico;

    /** Apenas informativo (opcional)
     * Pode ser usado para resposta da API*/
    private Integer idiva;

    //Valor real do IVA no momento (recomendado para respostas)
    private BigDecimal ivaatual;
}