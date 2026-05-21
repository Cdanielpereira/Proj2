package estg.ipvc.proj2.dtos.TipoColabDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoColabDto {
    private Integer id;
    private String type;
}