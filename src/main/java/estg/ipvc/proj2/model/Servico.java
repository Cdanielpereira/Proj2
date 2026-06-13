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
@Table(name = "servico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servico", nullable = false)
    private Integer id;
    @Column(name = "valorpagar", nullable = false, precision = 7, scale = 2)
    private BigDecimal valorpagar;
    @Column(name = "dt_marc", nullable = false)
    private LocalDate dtMarc;
    @Column(name = "dt_rea")
    private LocalDate dtRea;
    @Column(name = "id_faturap")
    private Integer idFaturap;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estadoser", nullable = false)
    private EstadoServico idEstadoser;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_colab", nullable = false)
    private Colaborador idColab;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_func", nullable = false)
    private Funcionario idFunc;

    @OneToMany(mappedBy = "idServico")
    private Set<Catering> caterings = new LinkedHashSet<>();
    @OneToMany(mappedBy = "idServico")
    private Set<Encomenda> encomendas = new LinkedHashSet<>();
    @OneToMany(mappedBy = "idServico")
    private Set<LinhaManu> linhasManu = new LinkedHashSet<>();
}