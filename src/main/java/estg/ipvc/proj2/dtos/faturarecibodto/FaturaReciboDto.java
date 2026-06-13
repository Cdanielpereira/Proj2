package estg.ipvc.proj2.dtos.faturarecibodto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FaturaReciboDto {
    private Integer id;
    private BigDecimal valor;
    private LocalDate dtPagamento;
    private BigDecimal nif;

    private Integer idMetodo;
}