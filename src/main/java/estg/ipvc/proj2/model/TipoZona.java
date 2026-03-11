package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tipo_zona")
public class TipoZona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipozona", nullable = false)
    private Integer id;

    @Column(name = "tipo", nullable = false, length = 30)
    private String tipo;

    @OneToMany(mappedBy = "idTipozona")
    private Set<Zona> zonas = new LinkedHashSet<>();

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

    public Set<Zona> getZonas() {
        return zonas;
    }

    public void setZonas(Set<Zona> zonas) {
        this.zonas = zonas;
    }

}