package estg.ipvc.proj2.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "vencimento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vencimento {
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
    private Contrato idContrato;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_metodo", nullable = false)
    private MetodoPagamento idMetodo;
}