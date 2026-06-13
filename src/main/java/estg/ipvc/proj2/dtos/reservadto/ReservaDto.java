package estg.ipvc.proj2.dtos.reservadto;

import lombok.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDto {
    private Integer idMarc;
    private Integer nquarto;
    private BigDecimal precoatual;
    private BigDecimal ivaatual;
}