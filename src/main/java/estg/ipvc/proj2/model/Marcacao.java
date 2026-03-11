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
    @Column(name = "id_marcacao", nullable = false)
    private Integer id;

    @Column(name = "dt_fim", nullable = false)
    private LocalDate dtFim;

    @Column(name = "dt_ini", nullable = false)
    private LocalDate dtIni;

    @Column(name = "dt_checkin")
    private LocalDate dtCheckin;

    @Column(name = "dt_checkout")
    private LocalDate dtCheckout;

    @Column(name = "valor", precision = 8, scale = 2)
    private BigDecimal valor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente idCliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_faturar")
    private FaturaRecibo idFaturar;

    @ManyToMany(mappedBy = "marcacaos")
    private Set<Quarto> quartos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDtFim() {
        return dtFim;
    }

    public void setDtFim(LocalDate dtFim) {
        this.dtFim = dtFim;
    }

    public LocalDate getDtIni() {
        return dtIni;
    }

    public void setDtIni(LocalDate dtIni) {
        this.dtIni = dtIni;
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public FaturaRecibo getIdFaturar() {
        return idFaturar;
    }

    public void setIdFaturar(FaturaRecibo idFaturar) {
        this.idFaturar = idFaturar;
    }

    public Set<Quarto> getQuartos() {
        return quartos;
    }

    public void setQuartos(Set<Quarto> quartos) {
        this.quartos = quartos;
    }

}