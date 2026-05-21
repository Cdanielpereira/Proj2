package estg.ipvc.proj2.dtos.ColaboradorDto;

import estg.ipvc.proj2.dtos.TipoColabDto.TipoColabDto;
import estg.ipvc.proj2.dtos.CpostalDto.CpostalDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ColaboradorDto {
    private Integer id;
    private TipoColabDto idTipocolab;
    private String nome;
    private String telefone;
    private String email;
    private String rua;
    private String nporta;
    private CpostalDto cpostal;
    private String iban;
}