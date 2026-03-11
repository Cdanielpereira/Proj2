package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zona")
public class Zona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zona", nullable = false)
    private Integer id;

    @Column(name = "andar", nullable = false)
    private Integer andar;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipozona", nullable = false)
    private TipoZona idTipozona;

    @OneToMany(mappedBy = "idZona")
    private Set<Limpeza> limpezas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idZona")
    private Set<Piscina> piscinas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idZona")
    private Set<Quarto> quartos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAndar() {
        return andar;
    }

    public void setAndar(Integer andar) {
        this.andar = andar;
    }

    public TipoZona getIdTipozona() {
        return idTipozona;
    }

    public void setIdTipozona(TipoZona idTipozona) {
        this.idTipozona = idTipozona;
    }

    public Set<Limpeza> getLimpezas() {
        return limpezas;
    }

    public void setLimpezas(Set<Limpeza> limpezas) {
        this.limpezas = limpezas;
    }

    public Set<Piscina> getPiscinas() {
        return piscinas;
    }

    public void setPiscinas(Set<Piscina> piscinas) {
        this.piscinas = piscinas;
    }

    public Set<Quarto> getQuartos() {
        return quartos;
    }

    public void setQuartos(Set<Quarto> quartos) {
        this.quartos = quartos;
    }

}