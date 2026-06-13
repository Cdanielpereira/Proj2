package estg.ipvc.proj2.dtos.servicodto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicoDto {
    private Integer id;
    private BigDecimal valorpagar;
    private LocalDate dtMarc;
    private LocalDate dtRea;

    private Integer idEstadoser;
    private Integer idColab;
    private Integer idFunc;

    private Integer idFaturap;
}