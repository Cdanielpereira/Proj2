package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tipo_colab")
public class TipoColab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipocolab", nullable = false)
    private Integer id;

    @Column(name = "tipo", nullable = false, length = 20)
    private String tipo;

    @OneToMany(mappedBy = "idTipocolab")
    private Set<Colaborador> colaboradors = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Set<Colaborador> getColaboradors() {
        return colaboradors;
    }

    public void setColaboradors(Set<Colaborador> colaboradors) {
        this.colaboradors = colaboradors;
    }

}