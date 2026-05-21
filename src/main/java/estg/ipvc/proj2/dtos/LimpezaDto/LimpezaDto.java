package estg.ipvc.proj2.dtos.LimpezaDto;

import estg.ipvc.proj2.dtos.ZonaDto.ZonaDto;
import estg.ipvc.proj2.dtos.FuncionarioDto.FuncionarioDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LimpezaDto {
    private Integer id;
    private ZonaDto idZona;
    private FuncionarioDto idFunc;
    private LocalDate dtReali;
}