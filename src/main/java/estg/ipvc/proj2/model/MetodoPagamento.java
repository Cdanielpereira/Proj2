package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "metodo_pagamento")
public class MetodoPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_metodo", nullable = false)
    private Integer id;

    @Column(name = "metodo", nullable = false, length = 100)
    private String metodo;

    @OneToMany(mappedBy = "idMetodo")
    private Set<FaturaPagamento> faturaPagamentos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idMetodo")
    private Set<FaturaRecibo> faturaRecibos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idMetodo")
    private Set<Vencimento> vencimentos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public Set<FaturaPagamento> getFaturaPagamentos() {
        return faturaPagamentos;
    }

    public void setFaturaPagamentos(Set<FaturaPagamento> faturaPagamentos) {
        this.faturaPagamentos = faturaPagamentos;
    }

    public Set<FaturaRecibo> getFaturaRecibos() {
        return faturaRecibos;
    }

    public void setFaturaRecibos(Set<FaturaRecibo> faturaRecibos) {
        this.faturaRecibos = faturaRecibos;
    }

    public Set<Vencimento> getVencimentos() {
        return vencimentos;
    }

    public void setVencimentos(Set<Vencimento> vencimentos) {
        this.vencimentos = vencimentos;
    }

}