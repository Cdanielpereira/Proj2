package goodstay_api.dtos.encomendadto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class EncomendaDto {
    private Integer id;
    private BigDecimal valortotal;
    private Integer idServico;
}