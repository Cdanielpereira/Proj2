package goodstay_api.dtos.vencimentodto;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VencimentoDto {
    private Integer id;
    private BigDecimal valor;
    private LocalDate dtPag;
    private LocalDate mes;
    private BigDecimal premio;
    private String iban;

    private Integer idContrato;
    private Integer idMetodo;
}