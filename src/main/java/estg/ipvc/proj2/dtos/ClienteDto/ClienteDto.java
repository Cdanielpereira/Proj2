package estg.ipvc.proj2.dtos.ClienteDto;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cliente")
public class ClienteDto {
    @Id
    private Long id;
    public Integer nif;
    public String nome;
    public LocalDate dtNasc;
    public String rua;
    public String porta;
    public String sexo;
    public Integer idUser;
    public Integer cpostal;
    public Integer idNacional;
    public String email;

    public ClienteDto(Long id, Integer nif, String nome, LocalDate dtNasc, String rua,
     String porta, String sexo, Integer idUser, Integer cpostal, Integer idNacional, String email) {
        this.id = id;
        this.nif = nif;
        this.nome = nome;
        this.dtNasc = dtNasc;
        this.rua = rua;
        this.porta = porta;
        this.sexo = sexo;
        this.idUser = idUser;
        this.cpostal = cpostal;
        this.idNacional = idNacional;
        this.email = email;
    }
        public ClienteDto() {

            }
}
