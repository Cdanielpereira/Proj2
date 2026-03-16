package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tipo_zona")
public class TipoZona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipoz", nullable = false)
    private Integer id;

    @Column(name = "type", nullable = false, length = 100)
    private String type;

    @OneToMany(mappedBy = "idTipoz")
    private Set<Zona> zonas = new LinkedHashSet<>();

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

    public Set<Zona> getZonas() {
        return zonas;
    }

    public void setZonas(Set<Zona> zonas) {
        this.zonas = zonas;
    }

}