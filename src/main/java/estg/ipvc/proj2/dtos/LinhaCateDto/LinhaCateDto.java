package estg.ipvc.proj2.dtos.LinhaCateDto;

import estg.ipvc.proj2.dtos.CateringDto.CateringDto;
import estg.ipvc.proj2.dtos.ServicoDto.ServicoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LinhaCateDto {
    private LinhaCateIdDto id;
    private CateringDto idCate;
    private ServicoDto idServico;
    private BigDecimal precoatual;
    private BigDecimal ivaatual;
}