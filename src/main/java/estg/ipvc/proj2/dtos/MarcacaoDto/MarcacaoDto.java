package estg.ipvc.proj2.dtos.MarcacaoDto;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "marcacao")
public class MarcacaoDto {
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
    private EstadoMarcacaoDto idEstadom;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private ClienteDto idCliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "if_faturar")
    private FaturaReciboDto ifFaturar;

    @OneToMany(mappedBy = "idMarc")
    private Set<ReservaDto> reservas = new LinkedHashSet<>();

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

    public EstadoMarcacaoDto getIdEstadom() {
        return idEstadom;
    }

    public void setIdEstadom(EstadoMarcacaoDto idEstadom) {
        this.idEstadom = idEstadom;
    }

    public ClienteDto getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(ClienteDto idCliente) {
        this.idCliente = idCliente;
    }

    public FaturaReciboDto getIfFaturar() {
        return ifFaturar;
    }

    public void setIfFaturar(FaturaReciboDto ifFaturar) {
        this.ifFaturar = ifFaturar;
    }

    public Set<ReservaDto> getReservas() {
        return reservas;
    }

    public void setReservas(Set<ReservaDto> reservas) {
        this.reservas = reservas;
    }

}
