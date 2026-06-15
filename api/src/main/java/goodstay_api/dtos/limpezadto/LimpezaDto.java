package goodstay_api.dtos.limpezadto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class LimpezaDto {
    private Integer idZona;
    private Integer idFunc;
    private LocalDate dtReali;
}