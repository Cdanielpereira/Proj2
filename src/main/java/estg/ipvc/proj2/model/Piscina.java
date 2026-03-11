package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "piscina")
public class Piscina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_piscina", nullable = false)
    private Integer id;

    @Column(name = "nivelph", precision = 4, scale = 2)
    private BigDecimal nivelph;

    @Column(name = "temp", precision = 4, scale = 2)
    private BigDecimal temp;

    @Column(name = "volume", precision = 8, scale = 2)
    private BigDecimal volume;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_zona", nullable = false)
    private Zona idZona;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getNivelph() {
        return nivelph;
    }

    public void setNivelph(BigDecimal nivelph) {
        this.nivelph = nivelph;
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

    public Zona getIdZona() {
        return idZona;
    }

    public void setIdZona(Zona idZona) {
        this.idZona = idZona;
    }

}