package estg.ipvc.proj2.dtos.MetodoPagamentoDto;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "metodo_pagamento")
public class MetodoPagamentoDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_metodo", nullable = false)
    private Integer id;

    @Column(name = "metodo", nullable = false, length = 100)
    private String metodo;

    @OneToMany(mappedBy = "idMetodo")
    private Set<FaturaPagamentoDto> faturaPagamentos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idMetodo")
    private Set<FaturaReciboDto> faturaRecibos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idMetodo")
    private Set<VencimentoDto> vencimentos = new LinkedHashSet<>();

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

    public Set<FaturaPagamentoDto> getFaturaPagamentos() {
        return faturaPagamentos;
    }

    public void setFaturaPagamentos(Set<FaturaPagamentoDto> faturaPagamentos) {
        this.faturaPagamentos = faturaPagamentos;
    }

    public Set<FaturaReciboDto> getFaturaRecibos() {
        return faturaRecibos;
    }

    public void setFaturaRecibos(Set<FaturaReciboDto> faturaRecibos) {
        this.faturaRecibos = faturaRecibos;
    }

    public Set<VencimentoDto> getVencimentos() {
        return vencimentos;
    }

    public void setVencimentos(Set<VencimentoDto> vencimentos) {
        this.vencimentos = vencimentos;
    }

}
