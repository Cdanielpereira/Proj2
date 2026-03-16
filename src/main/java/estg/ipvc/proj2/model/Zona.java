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
    private TipoZona idTipoz;

    @Column(name = "andar", length = 15)
    private String andar;

    @OneToMany(mappedBy = "idZona")
    private Set<Limpeza> limpezas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idZona")
    private Set<Manutencao> manutencaos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idZona")
    private Set<Piscina> piscinas = new LinkedHashSet<>();

    @OneToOne(mappedBy = "idZona")
    private Quarto quarto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoZona getIdTipoz() {
        return idTipoz;
    }

    public void setIdTipoz(TipoZona idTipoz) {
        this.idTipoz = idTipoz;
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

    public Set<Manutencao> getManutencaos() {
        return manutencaos;
    }

    public void setManutencaos(Set<Manutencao> manutencaos) {
        this.manutencaos = manutencaos;
    }

    public Set<Piscina> getPiscinas() {
        return piscinas;
    }

    public void setPiscinas(Set<Piscina> piscinas) {
        this.piscinas = piscinas;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

}