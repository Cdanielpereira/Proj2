package estg.ipvc.proj2.dtos.LinhaEncDto;

import estg.ipvc.proj2.dtos.EncomendaDto.EncomendaDto;
import estg.ipvc.proj2.dtos.ProdutoDto.ProdutoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LinhaEncDto {
    private Integer id;
    private EncomendaDto idEnco;
    private ProdutoDto idProduto;
    private BigDecimal precoatual;
    private Integer qtd;
    private BigDecimal ivaatual;
}