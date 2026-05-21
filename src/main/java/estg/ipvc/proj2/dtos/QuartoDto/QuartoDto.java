package estg.ipvc.proj2.dtos.QuartoDto;

import estg.ipvc.proj2.dtos.ZonaDto.ZonaDto;
import estg.ipvc.proj2.dtos.TipoQuartoDto.TipoQuartoDto;
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
public class QuartoDto {
    private Integer id;
    private BigDecimal preco;
    private ZonaDto idZona;
    private TipoQuartoDto idTipoq;
    private TipoIVADto idiva;
}