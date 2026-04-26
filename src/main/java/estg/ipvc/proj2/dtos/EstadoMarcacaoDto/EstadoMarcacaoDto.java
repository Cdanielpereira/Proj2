package estg.ipvc.proj2.dtos.EstadoMarcacaoDto;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "estado_marcacao")
public class EstadoMarcacaoDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estadom", nullable = false)
    private Integer id;

    @Column(name = "state", nullable = false, length = 100)
    private String state;

    @OneToMany(mappedBy = "idEstadom")
    private Set<MarcacaoDto> marcacaos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Set<MarcacaoDto> getMarcacaos() {
        return marcacaos;
    }

    public void setMarcacaos(Set<MarcacaoDto> marcacaos) {
        this.marcacaos = marcacaos;
    }

}
