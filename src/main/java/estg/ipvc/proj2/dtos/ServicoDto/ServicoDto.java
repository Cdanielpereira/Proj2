package estg.ipvc.proj2.dtos.ServicoDto;

import estg.ipvc.proj2.dtos.EstadoServicoDto.EstadoServicoDto;
import estg.ipvc.proj2.dtos.ColaboradorDto.ColaboradorDto;
import estg.ipvc.proj2.dtos.FuncionarioDto.FuncionarioDto;
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
public class ServicoDto {
    private Integer id;
    private BigDecimal valorpagar;
    private LocalDate dtMarc;
    private LocalDate dtRea;
    private EstadoServicoDto idEstadoser;
    private ColaboradorDto idColab;
    private FuncionarioDto idFunc;
    private Integer idFaturap;
}