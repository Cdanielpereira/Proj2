package estg.ipvc.proj2.dtos.tipoIVAdto;

import lombok.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoIVADto {
    private Integer id;
    private String descricao;
    private BigDecimal valor;
}