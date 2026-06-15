package goodstay_api.dtos.produtodto;

import lombok.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDto {
    private Integer id;
    private String nome;
    private BigDecimal valor;
    private Integer qtdstock;
    private Integer qtdmin;
    private Integer idIva;
}