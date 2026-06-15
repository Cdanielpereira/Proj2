package goodstay_api.dtos.funcionariodto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDto {
    private Integer id;

    private Integer idUser;
    private Integer idTipofunc;

    private String iban;
    private BigDecimal nif;

    private String rua;
    private String porta;

    private LocalDate dtNasc;
    private String sexo;
    private String nome;
    private String email;

    private String codPostal;
    private Integer idNacional;
}