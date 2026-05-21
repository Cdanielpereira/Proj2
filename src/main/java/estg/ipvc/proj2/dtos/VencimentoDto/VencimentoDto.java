package estg.ipvc.proj2.dtos.VencimentoDto;

import estg.ipvc.proj2.dtos.ContratoDto.ContratoDto;
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
public class VencimentoDto {
    private Integer id;
    private BigDecimal valor;
    private LocalDate dtPag;
    private LocalDate mes;
    private BigDecimal premio;
    private String iban;
    private ContratoDto idContrato;
    private MetodoPagamentoDto idMetodo;
}