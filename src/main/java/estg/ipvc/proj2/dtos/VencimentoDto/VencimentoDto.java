package estg.ipvc.proj2.dtos.VencimentoDto;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "vencimento")
public class VencimentoDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venc", nullable = false)
    private Integer id;

    @Column(name = "valor", nullable = false, precision = 7, scale = 2)
    private BigDecimal valor;

    @Column(name = "dt_pag", nullable = false)
    private LocalDate dtPag;

    @Column(name = "mes", nullable = false)
    private LocalDate mes;

    @Column(name = "premio")
    private BigDecimal premio;

    @Column(name = "iban", length = 30)
    private String iban;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_contrato", nullable = false)
    private ContratoDto idContrato;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_metodo", nullable = false)
    private MetodoPagamentoDto idMetodo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDtPag() {
        return dtPag;
    }

    public void setDtPag(LocalDate dtPag) {
        this.dtPag = dtPag;
    }

    public LocalDate getMes() {
        return mes;
    }

    public void setMes(LocalDate mes) {
        this.mes = mes;
    }

    public BigDecimal getPremio() {
        return premio;
    }

    public void setPremio(BigDecimal premio) {
        this.premio = premio;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public ContratoDto getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(ContratoDto idContrato) {
        this.idContrato = idContrato;
    }

    public MetodoPagamentoDto getIdMetodo() {
        return idMetodo;
    }

    public void setIdMetodo(MetodoPagamentoDto idMetodo) {
        this.idMetodo = idMetodo;
    }

}
