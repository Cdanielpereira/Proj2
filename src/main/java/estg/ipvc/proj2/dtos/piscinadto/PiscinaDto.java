package estg.ipvc.proj2.dtos.piscinadto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class PiscinaDto {
    private Integer id;
    private BigDecimal ph;
    private BigDecimal temp;
    private BigDecimal volume;
    private BigDecimal nivelCl;
    private Integer idZona;
}