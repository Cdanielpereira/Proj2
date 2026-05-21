package estg.ipvc.proj2.dtos.PiscinaDto;

import estg.ipvc.proj2.dtos.ZonaDto.ZonaDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PiscinaDto {
    private Integer id;
    private BigDecimal ph;
    private BigDecimal temp;
    private BigDecimal volume;
    private BigDecimal nivelCl;
    private ZonaDto idZona;
}