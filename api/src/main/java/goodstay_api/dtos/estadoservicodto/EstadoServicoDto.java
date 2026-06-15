package goodstay_api.dtos.estadoservicodto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstadoServicoDto {
    private Integer id;
    private String state;
}