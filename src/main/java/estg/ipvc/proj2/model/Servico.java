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
    private BigDecimal valorPagar;
    @Column(name = "dt_marc", nullable = false)
    private LocalDate dtMarc;
    @Column(name = "dt_rea")
    private LocalDate dtRea;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estadoser", nullable = false)
    private EstadoServico idEstadoSer;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_colab", nullable = false)
    private Colaborador idColab;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_func", nullable = false)
    private Funcionario idFunc;
    @Column(name = "id_faturap")
    private Integer idFaturaP;


    @OneToMany(mappedBy = "idServico")
    private Set<Catering> caterings = new LinkedHashSet<>();
    @OneToMany(mappedBy = "idServico")
    private Set<Encomenda> encomendas = new LinkedHashSet<>();
    @OneToMany(mappedBy = "idServico")
    private Set<Manutencao> manutencoes = new LinkedHashSet<>();


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValorPagar() {
        return valorPagar;
    }
    public void setValorPagar(BigDecimal valorPagar) {
        this.valorPagar = valorPagar;
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

    public EstadoServico getIdEstadoSer() {
        return idEstadoSer;
    }
    public void setIdEstadoSer(EstadoServico idEstadoSer) {
        this.idEstadoSer = idEstadoSer;
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

    public Integer getIdFaturaP() {
        return idFaturaP;
    }
    public void setIdFaturaP(Integer idFaturaP) {
        this.idFaturaP = idFaturaP;
    }

    public Set<Catering> getCaterings() {
        return caterings;
    }
    public void setCaterings(Set<Catering> caterings) {
        this.caterings = caterings;
    }

    public Set<Encomenda> getEncomendas() {
        return encomendas;
    }
    public void setEncomendas(Set<Encomenda> encomendas) {
        this.encomendas = encomendas;
    }

    public Set<Manutencao> getManutencoes() {
        return manutencoes;
    }
    public void setManutencoes(Set<Manutencao> manutencoes) {
        this.manutencoes = manutencoes;
    }

}