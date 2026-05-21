package estg.ipvc.proj2.dtos.MarcacaoDto;

import estg.ipvc.proj2.dtos.EstadoMarcacaoDto.EstadoMarcacaoDto;
import estg.ipvc.proj2.dtos.ClienteDto.ClienteDto;
import estg.ipvc.proj2.dtos.FaturaReciboDto.FaturaReciboDto;
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
public class MarcacaoDto {
    private Integer id;
    private LocalDate dtMarc;
    private LocalDate dtFim;
    private LocalDate dtCheckin;
    private LocalDate dtCheckout;
    private BigDecimal valort;
    private EstadoMarcacaoDto idEstadom;
    private ClienteDto idCliente;
    private FaturaReciboDto ifFaturar;
}