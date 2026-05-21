package estg.ipvc.proj2.dtos.TipoQuartoDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoQuartoDto {
    private Integer id;
    private String type;
}