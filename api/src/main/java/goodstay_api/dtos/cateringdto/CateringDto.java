package goodstay_api.dtos.cateringdto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CateringDto {

    private Integer id;
    private Integer nhospedes;
    private BigDecimal precohosp;

    private Integer idServico;
    private Integer idiva;
    private BigDecimal ivaatual;
}