package estg.ipvc.proj2.dtos.TipoZonaDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoZonaDto {
    private Integer id;
    private String type;
}