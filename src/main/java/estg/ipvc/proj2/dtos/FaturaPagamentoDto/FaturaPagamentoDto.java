package estg.ipvc.proj2.dtos.FaturaPagamentoDto;

import estg.ipvc.proj2.dtos.FuncionarioDto.FuncionarioDto;
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
public class FaturaPagamentoDto {
    private Integer id;
    private String iban;
    private BigDecimal valorpago;
    private LocalDate dtPag;
    private FuncionarioDto idFunc;
    private MetodoPagamentoDto idMetodo;
}