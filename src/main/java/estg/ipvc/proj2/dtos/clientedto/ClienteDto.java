package estg.ipvc.proj2.dtos.clientedto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class ClienteDto {
    private Integer id;
    private Integer nif;
    private String nome;
    private LocalDate dtNasc;
    private String rua;
    private String porta;
    private String sexo;

    private Integer idUser;
    private String codPostal;
    private Integer idNacional;

    private String email;
}