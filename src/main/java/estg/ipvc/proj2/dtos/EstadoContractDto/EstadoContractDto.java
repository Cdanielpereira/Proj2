package estg.ipvc.proj2.dtos.EstadoContractDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstadoContractDto {
    private Integer id;
    private String state;
}