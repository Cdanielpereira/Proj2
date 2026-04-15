package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "quarto")
public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nquarto", nullable = false)
    private Integer nQuarto;
    @Column(name = "preco", nullable = false, precision = 5, scale = 2)
    private BigDecimal preco;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_zona", nullable = false)
    private Zona idZona;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipoq", nullable = false)
    private TipoQuarto idTipoQ;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idiva", nullable = false)
    private TipoIVA idIVA;


    @OneToMany(mappedBy = "nQuarto")
    private Set<Reserva> reservas = new LinkedHashSet<>();


    public Integer getNQuarto() {
        return nQuarto;
    }
    public void setNQuarto(Integer nQuarto) {
        this.nQuarto = nQuarto;
    }

    public BigDecimal getPreco() {
        return preco;
    }
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Zona getIdZona() {
        return idZona;
    }
    public void setIdZona(Zona idZona) {
        this.idZona = idZona;
    }

    public TipoQuarto getIdTipoQ() {
        return idTipoQ;
    }
    public void setIdTipoQ(TipoQuarto idTipoQ) {
        this.idTipoQ = idTipoQ;
    }

    public TipoIVA getTipoIVA() {
        return idIVA;
    }
    public void setTipoIVA(TipoIVA idIVA) {
        this.idIVA = idIVA;
    }

    public Set<Reserva> getReservas() {
        return reservas;
    }
    public void setReservas(Set<Reserva> reservas) {
        this.reservas = reservas;
    }

}