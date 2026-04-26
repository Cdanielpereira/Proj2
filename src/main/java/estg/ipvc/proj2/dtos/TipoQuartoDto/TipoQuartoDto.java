package estg.ipvc.proj2.dtos.TipoQuartoDto;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tipo_quarto")
public class TipoQuartoDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipoq", nullable = false)
    private Integer id;

    @Column(name = "type", nullable = false, length = 20)
    private String type;

    @OneToMany(mappedBy = "idTipoq")
    private Set<QuartoDto> quartos = new LinkedHashSet<>();

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

    public Set<QuartoDto> getQuartos() {
        return quartos;
    }

    public void setQuartos(Set<QuartoDto> quartos) {
        this.quartos = quartos;
    }

}
