package estg.ipvc.proj2.dtos.PiscinaDto;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "piscina")
public class PiscinaDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_piscina", nullable = false)
    private Integer id;

    @Column(name = "ph", precision = 10, scale = 2)
    private BigDecimal ph;

    @Column(name = "temp", precision = 100, scale = 2)
    private BigDecimal temp;

    @Column(name = "volume", nullable = false, precision = 4, scale = 2)
    private BigDecimal volume;

    @Column(name = "nivel_cl", precision = 5, scale = 2)
    private BigDecimal nivelCl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_zona")
    private ZonaDto idZona;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPh() {
        return ph;
    }

    public void setPh(BigDecimal ph) {
        this.ph = ph;
    }

    public BigDecimal getTemp() {
        return temp;
    }

    public void setTemp(BigDecimal temp) {
        this.temp = temp;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getNivelCl() {
        return nivelCl;
    }

    public void setNivelCl(BigDecimal nivelCl) {
        this.nivelCl = nivelCl;
    }

    public ZonaDto getIdZona() {
        return idZona;
    }

    public void setIdZona(ZonaDto idZona) {
        this.idZona = idZona;
    }

}
