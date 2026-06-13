package estg.ipvc.proj2.dtos.faturapagamentodto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FaturaPagamentoDto {
    private Integer id;
    private String iban;
    private BigDecimal valorpago;
    private LocalDate dtPag;

    private Integer idFunc;
    private Integer idMetodo;
}