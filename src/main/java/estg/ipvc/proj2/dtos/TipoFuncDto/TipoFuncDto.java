package estg.ipvc.proj2.dtos.TipoFuncDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoFuncDto {
    private Integer id;
    private String type;
}