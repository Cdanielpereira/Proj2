package estg.ipvc.proj2.dtos.ProdutoDto;

import estg.ipvc.proj2.dtos.TipoIVADto.TipoIVADto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {
    private Integer id;
    private String nome;
    private BigDecimal valor;
    private Integer qtdstock;
    private Integer qtdmin;
    private TipoIVADto idiva;
}