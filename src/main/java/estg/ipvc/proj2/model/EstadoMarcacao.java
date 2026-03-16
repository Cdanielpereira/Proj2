package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "estado_marcacao")
public class EstadoMarcacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estadom", nullable = false)
    private Integer id;

    @Column(name = "state", nullable = false, length = 100)
    private String state;

    @OneToMany(mappedBy = "idEstadom")
    private Set<Marcacao> marcacaos = new LinkedHashSet<>();

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

    public Set<Marcacao> getMarcacaos() {
        return marcacaos;
    }

    public void setMarcacaos(Set<Marcacao> marcacaos) {
        this.marcacaos = marcacaos;
    }

}