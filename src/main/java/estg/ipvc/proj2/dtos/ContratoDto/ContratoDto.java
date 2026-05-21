package estg.ipvc.proj2.dtos.ContratoDto;

import estg.ipvc.proj2.dtos.FuncionarioDto.FuncionarioDto;
import estg.ipvc.proj2.dtos.EstadoContractDto.EstadoContractDto;
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
public class ContratoDto {
    private Integer id;
    private BigDecimal salario;
    private LocalDate dtCriado;
    private LocalDate dtAssinado;
    private LocalDate dtIni;
    private LocalDate dtFim;
    private FuncionarioDto idFunc;
    private EstadoContractDto idEstadoc;
}