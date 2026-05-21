package estg.ipvc.proj2.dtos.ClienteDto;

import estg.ipvc.proj2.dtos.UserDto.UserDto;
import estg.ipvc.proj2.dtos.CpostalDto.CpostalDto;
import estg.ipvc.proj2.dtos.NacionalidadeDto.NacionalidadeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {
    private Integer id;
    private Integer nif;
    private String nome;
    private LocalDate dtNasc;
    private String rua;
    private String porta;
    private String sexo;
    private UserDto idUser;
    private CpostalDto cpostal;
    private NacionalidadeDto idNacional;
    private String email;
}