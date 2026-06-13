package estg.ipvc.proj2.dtos.limpezadto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class LimpezaDto {
    private Integer idZona;
    private Integer idFunc;
    private LocalDate dtReali;
}