package estg.ipvc.proj2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "fatura_recibo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FaturaRecibo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_faturar", nullable = false)
    private Integer id;
    @Column(name = "valor", nullable = false, precision = 1000, scale = 2)
    private BigDecimal valor;
    @Column(name = "dt_pagamento", nullable = false)
    private LocalDate dtPagamento;
    @Column(name = "nif", precision = 15, scale = 2)
    private BigDecimal nif;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_metodo", nullable = false)
    private MetodoPagamento idMetodo;

    @OneToMany(mappedBy = "ifFaturar")
    private Set<Marcacao> marcacaos = new LinkedHashSet<>();
}