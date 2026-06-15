package goodstay_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "fatura_pagamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}