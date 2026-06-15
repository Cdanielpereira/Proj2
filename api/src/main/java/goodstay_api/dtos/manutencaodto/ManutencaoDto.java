package goodstay_api.dtos.manutencaodto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ManutencaoDto {
    private Integer id;
    private String descricao;
    private Integer idZona;
    private Integer idiva;
}