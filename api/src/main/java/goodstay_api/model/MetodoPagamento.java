package goodstay_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "metodo_pagamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}