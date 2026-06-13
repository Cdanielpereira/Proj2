package estg.ipvc.proj2.dtos.linhaencdto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class LinhaEncDto {
    private Integer idEnco;
    private Integer idProduto;
    private BigDecimal precoatual;
    private Integer qtd;
    private BigDecimal ivaatual;
}