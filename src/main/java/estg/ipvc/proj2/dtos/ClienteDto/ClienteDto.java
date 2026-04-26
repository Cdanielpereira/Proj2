package estg.ipvc.proj2.dtos.ClienteDto;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cliente")
public class ClienteDto {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
