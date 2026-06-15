package goodstay_api.dtos.nacionalidadedto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NacionalidadeDto {
    private Integer id;
    private String state;
}