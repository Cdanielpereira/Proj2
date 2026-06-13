package estg.ipvc.proj2.dtos.estadoservicodto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstadoServicoDto {
    private Integer id;
    private String state;
}