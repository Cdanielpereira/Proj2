package estg.ipvc.proj2.dtos.MetodoPagamentoDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MetodoPagamentoDto {
    private Integer id;
    private String metodo;
}