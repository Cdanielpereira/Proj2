package estg.ipvc.proj2.dtos.EstadoMarcacaoDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstadoMarcacaoDto {
    private Integer id;
    private String state;
}