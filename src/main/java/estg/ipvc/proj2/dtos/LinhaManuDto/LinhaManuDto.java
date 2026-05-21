package estg.ipvc.proj2.dtos.LinhaManuDto;

import estg.ipvc.proj2.dtos.ManutencaoDto.ManutencaoDto;
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
public class LinhaManuDto {
    private Integer id;
    private ManutencaoDto idManu;
    private ServicoDto idServico;
    private BigDecimal precoatual;
    private BigDecimal ivaatual;
}