package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "marcacao")
public class Marcacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marc", nullable = false)
    private Integer id;

    @Column(name = "dt_marc", nullable = false)
    private LocalDate dtMarc;

    @Column(name = "dt_fim", nullable = false)
    private LocalDate dtFim;

    @Column(name = "dt_checkin")
    private LocalDate dtCheckin;

    @Column(name = "dt_checkout")
    private LocalDate dtCheckout;

    @Column(name = "valort", nullable = false, precision = 1000, scale = 2)
    private BigDecimal valort;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estadom", nullable = false)
    private EstadoMarcacao idEstadom;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente idCliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "if_faturar")
    private FaturaRecibo ifFaturar;

    @OneToMany(mappedBy = "idMarc")
    private Set<Reserva> reservas = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDtMarc() {
        return dtMarc;
    }

    public void setDtMarc(LocalDate dtMarc) {
        this.dtMarc = dtMarc;
    }

    public LocalDate getDtFim() {
        return dtFim;
    }

    public void setDtFim(LocalDate dtFim) {
        this.dtFim = dtFim;
    }

    public LocalDate getDtCheckin() {
        return dtCheckin;
    }

    public void setDtCheckin(LocalDate dtCheckin) {
        this.dtCheckin = dtCheckin;
    }

    public LocalDate getDtCheckout() {
        return dtCheckout;
    }

    public void setDtCheckout(LocalDate dtCheckout) {
        this.dtCheckout = dtCheckout;
    }

    public BigDecimal getValort() {
        return valort;
    }

    public void setValort(BigDecimal valort) {
        this.valort = valort;
    }

    public EstadoMarcacao getIdEstadom() {
        return idEstadom;
    }

    public void setIdEstadom(EstadoMarcacao idEstadom) {
        this.idEstadom = idEstadom;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public FaturaRecibo getIfFaturar() {
        return ifFaturar;
    }

    public void setIfFaturar(FaturaRecibo ifFaturar) {
        this.ifFaturar = ifFaturar;
    }

    public Set<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Set<Reserva> reservas) {
        this.reservas = reservas;
    }

}