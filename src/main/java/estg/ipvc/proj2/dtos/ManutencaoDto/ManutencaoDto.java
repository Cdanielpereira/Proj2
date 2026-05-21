package estg.ipvc.proj2.dtos.ManutencaoDto;

import estg.ipvc.proj2.dtos.ZonaDto.ZonaDto;
import estg.ipvc.proj2.dtos.TipoIVADto.TipoIVADto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ManutencaoDto {
    private Integer id;
    private String descricao;
    private ZonaDto idZona;
    private TipoIVADto idiva;
}