package estg.ipvc.proj2.dtos.FaturaReciboDto;

import estg.ipvc.proj2.dtos.MetodoPagamentoDto.MetodoPagamentoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FaturaReciboDto {
    private Integer id;
    private BigDecimal valor;
    private LocalDate dtPagamento;
    private MetodoPagamentoDto idMetodo;
    private BigDecimal nif;
}