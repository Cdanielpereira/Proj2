package estg.ipvc.proj2.dtos.EncomendaDto;

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
public class EncomendaDto {
    private Integer id;
    private BigDecimal valortotal;
    private ServicoDto idServico;
}