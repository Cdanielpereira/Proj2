package estg.ipvc.proj2.dtos.FuncionarioDto;

import estg.ipvc.proj2.dtos.UserDto.UserDto;
import estg.ipvc.proj2.dtos.TipoFuncDto.TipoFuncDto;
import estg.ipvc.proj2.dtos.CpostalDto.CpostalDto;
import estg.ipvc.proj2.dtos.NacionalidadeDto.NacionalidadeDto;
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
public class FuncionarioDto {
    private Integer id;
    private UserDto idUser;
    private TipoFuncDto idTipofunc;
    private String iban;
    private BigDecimal nif;
    private String rua;
    private String porta;
    private LocalDate dtNasc;
    private String sexo;
    private String nome;
    private String email;
    private CpostalDto cpostal;
    private NacionalidadeDto idNacional;
}