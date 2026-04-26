package estg.ipvc.proj2.dtos;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "quarto")
public class QuartoDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nquarto", nullable = false)
    private Integer id;

    @Column(name = "preco", nullable = false, precision = 5, scale = 2)
    private BigDecimal preco;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_zona", nullable = false)
    private ZonaDto idZona;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipoq", nullable = false)
    private TipoQuartoDto idTipoq;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idiva", nullable = false)
    private TipoIVADto idiva;

    @OneToMany(mappedBy = "nquarto")
    private Set<ReservaDto> reservas = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPreco() {
        return preco;
    }
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public ZonaDto getIdZona() {
        return idZona;
    }
    public void setIdZona(ZonaDto idZona) {
        this.idZona = idZona;
    }

    public TipoQuartoDto getIdTipoq() {
        return idTipoq;
    }
    public void setIdTipoq(TipoQuartoDto idTipoq) {
        this.idTipoq = idTipoq;
    }

    public TipoIVADto getIdTipoIVA() {
        return idiva;
    }
    public void setIdTipoIVA(TipoIVADto idiva) {
        this.idiva = idiva;
    }

    public Set<ReservaDto> getReservas() {
        return reservas;
    }
    public void setReservas(Set<ReservaDto> reservas) {
        this.reservas = reservas;
    }

}