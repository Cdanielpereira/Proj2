package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "fatura_recibo")
public class FaturaRecibo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_faturar", nullable = false)
    private Integer id;

    @Column(name = "valor", nullable = false, precision = 1000, scale = 2)
    private BigDecimal valor;

    @Column(name = "dt_pagamento", nullable = false)
    private LocalDate dtPagamento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_metodo", nullable = false)
    private MetodoPagamento idMetodo;

    @Column(name = "nif", precision = 15, scale = 2)
    private BigDecimal nif;

    @OneToMany(mappedBy = "ifFaturar")
    private Set<Marcacao> marcacoes = new LinkedHashSet<>();

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

    public LocalDate getDtPagamento() {
        return dtPagamento;
    }

    public void setDtPagamento(LocalDate dtPagamento) {
        this.dtPagamento = dtPagamento;
    }

    public MetodoPagamento getIdMetodo() {
        return idMetodo;
    }

    public void setIdMetodo(MetodoPagamento idMetodo) {
        this.idMetodo = idMetodo;
    }

    public BigDecimal getNif() {
        return nif;
    }

    public void setNif(BigDecimal nif) {
        this.nif = nif;
    }

    public Set<Marcacao> getMarcacoes() {
        return marcacoes;
    }

    public void setMarcacoes(Set<Marcacao> marcacoes) {
        this.marcacoes = marcacoes;
    }

}