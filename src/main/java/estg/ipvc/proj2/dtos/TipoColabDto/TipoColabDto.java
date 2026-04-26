package estg.ipvc.proj2.dtos.TipoColabDto;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tipo_colab")
public class TipoColabDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_colab", nullable = false)
    private Integer id;

    @Column(name = "type", nullable = false, length = 20)
    private String type;

    @OneToMany(mappedBy = "idTipocolab")
    private Set<ColaboradorDto> colaboradors = new LinkedHashSet<>();

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

    public Set<ColaboradorDto> getColaboradors() {
        return colaboradors;
    }

    public void setColaboradors(Set<ColaboradorDto> colaboradors) {
        this.colaboradors = colaboradors;
    }

}
