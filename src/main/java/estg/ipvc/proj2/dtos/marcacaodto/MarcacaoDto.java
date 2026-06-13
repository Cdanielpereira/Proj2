package estg.ipvc.proj2.dtos.marcacaodto;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

@Data
public class MarcacaoDto {
    private Integer id;
    private LocalDate dtMarc;
    private LocalDate dtFim;
    private LocalDate dtCheckin;
    private LocalDate dtCheckout;
    private BigDecimal valort;

    private Integer idEstadom;
    private Integer idCliente;
    private Integer ifFaturar;
}