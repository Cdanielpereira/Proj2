package estg.ipvc.proj2.dtos.quartodto;

import lombok.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuartoDto {
    private Integer id;
    private BigDecimal preco;
    private Integer idZona;
    private Integer idTipoq;
    private Integer idTipoIVA;
}