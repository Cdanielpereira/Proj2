package estg.ipvc.proj2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "contrato")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contrato", nullable = false)
    private Integer id;
    @ColumnDefault("920")
    @Column(name = "salario", nullable = false, precision = 7, scale = 2)
    private BigDecimal salario;
    @Column(name = "dt_criado", nullable = false)
    private LocalDate dtCriado;
    @Column(name = "dt_assinado")
    private LocalDate dtAssinado;
    @Column(name = "dt_ini", nullable = false)
    private LocalDate dtIni;
    @Column(name = "dt_fim", nullable = false)
    private LocalDate dtFim;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_func", nullable = false)
    private Funcionario idFunc;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estadoc", nullable = false)
    private EstadoContract idEstadoc;

    @OneToMany(mappedBy = "idContrato")
    private Set<Vencimento> vencimentos = new LinkedHashSet<>();
}