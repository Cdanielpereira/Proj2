package estg.ipvc.proj2.dtos.ZonaDto;

import estg.ipvc.proj2.dtos.TipoZonaDto.TipoZonaDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ZonaDto {
    private Integer id;
    private TipoZonaDto idTipoz;
    private String andar;
}