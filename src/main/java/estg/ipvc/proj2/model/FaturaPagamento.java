package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "fatura_pagamento")
public class FaturaPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_faturap", nullable = false)
    private Integer id;

    @Column(name = "iban", length = 30)
    private String iban;

    @Column(name = "valorpago", nullable = false, precision = 7, scale = 2)
    private BigDecimal valorpago;

    @Column(name = "dt_pag", nullable = false)
    private LocalDate dtPag;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_func", nullable = false)
    private Funcionario idFunc;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_metodo", nullable = false)
    private MetodoPagamento idMetodo;

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

    public BigDecimal getValorpago() {
        return valorpago;
    }

    public void setValorpago(BigDecimal valorpago) {
        this.valorpago = valorpago;
    }

    public LocalDate getDtPag() {
        return dtPag;
    }

    public void setDtPag(LocalDate dtPag) {
        this.dtPag = dtPag;
    }

    public Funcionario getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(Funcionario idFunc) {
        this.idFunc = idFunc;
    }

    public MetodoPagamento getIdMetodo() {
        return idMetodo;
    }

    public void setIdMetodo(MetodoPagamento idMetodo) {
        this.idMetodo = idMetodo;
    }

}