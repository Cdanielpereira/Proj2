package goodstay_api.dtos.tipozonadto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoZonaDto {
    private Integer id;
    private String type;
}