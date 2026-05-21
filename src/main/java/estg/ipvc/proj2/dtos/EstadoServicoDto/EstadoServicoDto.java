package estg.ipvc.proj2.dtos.EstadoServicoDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstadoServicoDto {
    private Integer id;
    private String state;
}