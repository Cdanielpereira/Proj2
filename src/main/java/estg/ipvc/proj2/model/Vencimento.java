package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Entity
@Table(name = "vencimento")
public class Vencimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_faturap", nullable = false)
    private Integer id;

    @Column(name = "iban", length = 25)
    private String iban;

    @Column(name = "premio", precision = 5, scale = 2)
    private BigDecimal premio;

    @Column(name = "mes", nullable = false)
    private LocalDate mes;

    @Column(name = "valor", nullable = false, precision = 8, scale = 2)
    private BigDecimal valor;

    @Column(name = "dt_pag", nullable = false)
    private OffsetDateTime dtPag;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_contf", nullable = false)
    private ContratoFunc idContf;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public BigDecimal getPremio() {
        return premio;
    }

    public void setPremio(BigDecimal premio) {
        this.premio = premio;
    }

    public LocalDate getMes() {
        return mes;
    }

    public void setMes(LocalDate mes) {
        this.mes = mes;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public OffsetDateTime getDtPag() {
        return dtPag;
    }

    public void setDtPag(OffsetDateTime dtPag) {
        this.dtPag = dtPag;
    }

    public ContratoFunc getIdContf() {
        return idContf;
    }

    public void setIdContf(ContratoFunc idContf) {
        this.idContf = idContf;
    }

}