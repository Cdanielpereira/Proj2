package goodstay_api.dtos.tipofuncdto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoFuncDto {
    private Integer id;
    private String type;
}