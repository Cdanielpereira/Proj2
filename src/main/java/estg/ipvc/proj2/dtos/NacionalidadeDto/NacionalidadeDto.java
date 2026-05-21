package estg.ipvc.proj2.dtos.NacionalidadeDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NacionalidadeDto {
    private Integer id;
    private String nacionalidade;
}