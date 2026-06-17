package goodstay_api.dtos.contratodto;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContratoDto {

    private Integer id;

    private BigDecimal salario;

    private LocalDate dtCriado;
    private LocalDate dtAssinado;
    private LocalDate dtIni;
    private LocalDate dtFim;

    private Integer idFunc;
    private Integer idEstadoc;
}