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
    private Integer id;

    @Column(name = "preco", nullable = false, precision = 5, scale = 2)
    private BigDecimal preco;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_zona", nullable = false)
    private Zona idZona;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipoq", nullable = false)
    private TipoQuarto idTipoq;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idiva", nullable = false)
    private TipoIVA idiva;

    @OneToMany(mappedBy = "nquarto")
    private Set<Reserva> reservas = new LinkedHashSet<>();

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

    public Zona getIdZona() {
        return idZona;
    }
    public void setIdZona(Zona idZona) {
        this.idZona = idZona;
    }

    public TipoQuarto getIdTipoq() {
        return idTipoq;
    }
    public void setIdTipoq(TipoQuarto idTipoq) {
        this.idTipoq = idTipoq;
    }

    public TipoIVA getIdTipoIVA() {
        return idiva;
    }
    public void setIdTipoIVA(TipoIVA idiva) {
        this.idiva = idiva;
    }

    public Set<Reserva> getReservas() {
        return reservas;
    }
    public void setReservas(Set<Reserva> reservas) {
        this.reservas = reservas;
    }

}