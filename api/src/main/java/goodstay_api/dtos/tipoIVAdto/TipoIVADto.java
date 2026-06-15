package goodstay_api.dtos.tipoIVAdto;

import lombok.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoIVADto {
    private Integer id;
    private String type;
    private BigDecimal valor;
}