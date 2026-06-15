package goodstay_api.dtos.zonadto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZonaDto {
    private Integer id;
    private Integer idTipoz;
    private String andar;
}