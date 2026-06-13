package estg.ipvc.proj2.dtos.colaboradordto;

import lombok.Data;

@Data
public class ColaboradorDto {
    private Integer id;

    private Integer idTipocolab;

    private String nome;
    private String telefone;
    private String email;

    private String rua;
    private String nporta;

    private String codPostal;

    private String iban;
}