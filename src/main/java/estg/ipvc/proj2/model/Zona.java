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
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipoz", nullable = false)
    private TipoZona idTipoZ;
    @Column(name = "andar", length = 15)
    private String andar;


    @OneToMany(mappedBy = "idZona")
    private Set<Limpeza> limpezas = new LinkedHashSet<>();
    @OneToMany(mappedBy = "idZona")
    private Set<Manutencao> manutencoes = new LinkedHashSet<>();
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

    public TipoZona getIdTipoZ() {
        return idTipoZ;
    }
    public void setIdTipoZ(TipoZona idTipoZ) {
        this.idTipoZ = idTipoZ;
    }

    public String getAndar() {
        return andar;
    }
    public void setAndar(String andar) {
        this.andar = andar;
    }

    public Set<Limpeza> getLimpezas() {
        return limpezas;
    }
    public void setLimpezas(Set<Limpeza> limpezas) {
        this.limpezas = limpezas;
    }

    public Set<Manutencao> getManutencoes() {
        return manutencoes;
    }
    public void setManutencoes(Set<Manutencao> manutencoes) {
        this.manutencoes = manutencoes;
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