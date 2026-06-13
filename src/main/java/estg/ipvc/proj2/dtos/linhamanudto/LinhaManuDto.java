package estg.ipvc.proj2.dtos.linhamanudto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class LinhaManuDto {
    private Integer idManu;
    private Integer idServico;
    private BigDecimal precoatual;
    private BigDecimal ivaatual;
}