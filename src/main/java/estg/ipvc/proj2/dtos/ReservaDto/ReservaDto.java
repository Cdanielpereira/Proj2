package estg.ipvc.proj2.dtos.ReservaDto;

import estg.ipvc.proj2.dtos.MarcacaoDto.MarcacaoDto;
import estg.ipvc.proj2.dtos.QuartoDto.QuartoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDto {
    private ReservaIdDto id;
    private MarcacaoDto idMarc;
    private QuartoDto nquarto;
    private BigDecimal precoatual;
    private BigDecimal ivaatual;
}