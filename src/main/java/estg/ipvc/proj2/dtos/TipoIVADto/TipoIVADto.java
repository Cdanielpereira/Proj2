package estg.ipvc.proj2.dtos.TipoIVADto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoIVADto {
    private Integer id;
    private String type;
    private BigDecimal valor;
}