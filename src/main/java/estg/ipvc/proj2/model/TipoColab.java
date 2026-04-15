package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tipo_colab")
public class TipoColab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_colab", nullable = false)
    private Integer id;
    @Column(name = "type", nullable = false, length = 20)
    private String type;


    @OneToMany(mappedBy = "idTipoColab")
    private Set<Colaborador> colaboradores = new LinkedHashSet<>();


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Set<Colaborador> getColaboradores() {
        return colaboradores;
    }
    public void setColaboradores(Set<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }

}