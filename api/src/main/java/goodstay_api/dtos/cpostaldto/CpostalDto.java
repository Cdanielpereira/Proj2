package goodstay_api.dtos.cpostaldto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CpostalDto {
    private String codPostal;
    private String localidade;
}