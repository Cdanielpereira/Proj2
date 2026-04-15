package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "servico")
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
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estadoser", nullable = false)
    private EstadoServico idEstadoser;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_colab", nullable = false)
    private Colaborador idColab;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_func", nullable = false)
    private Funcionario idFunc;
    @Column(name = "id_faturap")
    private Integer idFaturap;


    @OneToMany(mappedBy = "idServico")
    private Set<LinhaCate> linhasCate = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idServico")
    private Set<Encomenda> encomendas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idServico")
    private Set<LinhaManu> linhasManu = new LinkedHashSet<>();


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValorpagar() {
        return valorpagar;
    }
    public void setValorpagar(BigDecimal valorpagar) {
        this.valorpagar = valorpagar;
    }

    public LocalDate getDtMarc() {
        return dtMarc;
    }
    public void setDtMarc(LocalDate dtMarc) {
        this.dtMarc = dtMarc;
    }

    public LocalDate getDtRea() {
        return dtRea;
    }
    public void setDtRea(LocalDate dtRea) {
        this.dtRea = dtRea;
    }

    public EstadoServico getIdEstadoser() {
        return idEstadoser;
    }
    public void setIdEstadoser(EstadoServico idEstadoser) {
        this.idEstadoser = idEstadoser;
    }

    public Colaborador getIdColab() {
        return idColab;
    }
    public void setIdColab(Colaborador idColab) {
        this.idColab = idColab;
    }

    public Funcionario getIdFunc() {
        return idFunc;
    }
    public void setIdFunc(Funcionario idFunc) {
        this.idFunc = idFunc;
    }

    public Integer getIdFaturap() {
        return idFaturap;
    }
    public void setIdFaturap(Integer idFaturap) {
        this.idFaturap = idFaturap;
    }

    public Set<LinhaCate> getLinhasCate() {
        return linhasCate;
    }
    public void setLinhasCate(Set<LinhaCate> linhasCate) { this.linhasCate = linhasCate; }

    public Set<Encomenda> getEncomendas() {
        return encomendas;
    }
    public void setEncomendas(Set<Encomenda> encomendas) {
        this.encomendas = encomendas;
    }

    public Set<LinhaManu> getLinhasManu() {
        return linhasManu;
    }
    public void setLinhasManu(Set<LinhaManu> linhasManu) { this.linhasManu = linhasManu; }

}