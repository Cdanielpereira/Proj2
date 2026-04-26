package estg.ipvc.proj2.dtos.ZonaDto;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

import estg.ipvc.proj2.dtos.TipoZonaDto.TipoZonaDto;
import estg.ipvc.proj2.dtos.LimpezaDto.LimpezaDto;
import estg.ipvc.proj2.dtos.ManutencaoDto.ManutencaoDto;
import estg.ipvc.proj2.dtos.PiscinaDto.PiscinaDto;
import estg.ipvc.proj2.dtos.QuartoDto.QuartoDto;

@Entity
@Table(name = "zona")
public class ZonaDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zona", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipoz", nullable = false)
    private TipoZonaDto idTipoz;

    @Column(name = "andar", length = 15)
    private String andar;

    @OneToMany(mappedBy = "idZona")
    private Set<LimpezaDto> limpezas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idZona")
    private Set<ManutencaoDto> manutencaos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idZona")
    private Set<PiscinaDto> piscinas = new LinkedHashSet<>();

    @OneToOne(mappedBy = "idZona")
    private QuartoDto quarto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoZonaDto getIdTipoz() {
        return idTipoz;
    }

    public void setIdTipoz(TipoZonaDto idTipoz) {
        this.idTipoz = idTipoz;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public Set<LimpezaDto> getLimpezas() {
        return limpezas;
    }

    public void setLimpezas(Set<LimpezaDto> limpezas) {
        this.limpezas = limpezas;
    }

    public Set<ManutencaoDto> getManutencaos() {
        return manutencaos;
    }

    public void setManutencaos(Set<ManutencaoDto> manutencaos) {
        this.manutencaos = manutencaos;
    }

    public Set<PiscinaDto> getPiscinas() {
        return piscinas;
    }

    public void setPiscinas(Set<PiscinaDto> piscinas) {
        this.piscinas = piscinas;
    }

    public QuartoDto getQuarto() {
        return quarto;
    }

    public void setQuarto(QuartoDto quarto) {
        this.quarto = quarto;
    }

}
