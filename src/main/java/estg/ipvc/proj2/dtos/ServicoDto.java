package estg.ipvc.proj2.dtos;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "servico")
public class ServicoDto {
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
    private EstadoServicoDto idEstadoser;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_colab", nullable = false)
    private ColaboradorDto idColab;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_func", nullable = false)
    private FuncionarioDto idFunc;
    @Column(name = "id_faturap")
    private Integer idFaturap;


    @OneToMany(mappedBy = "idServico")
    private Set<LinhaCateDto> linhasCate = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idServico")
    private Set<EncomendaDto> encomendas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idServico")
    private Set<LinhaManuDto> linhasManu = new LinkedHashSet<>();


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

    public EstadoServicoDto getIdEstadoser() {
        return idEstadoser;
    }
    public void setIdEstadoser(EstadoServicoDto idEstadoser) {
        this.idEstadoser = idEstadoser;
    }

    public ColaboradorDto getIdColab() {
        return idColab;
    }
    public void setIdColab(ColaboradorDto idColab) {
        this.idColab = idColab;
    }

    public FuncionarioDto getIdFunc() {
        return idFunc;
    }
    public void setIdFunc(FuncionarioDto idFunc) {
        this.idFunc = idFunc;
    }

    public Integer getIdFaturap() {
        return idFaturap;
    }
    public void setIdFaturap(Integer idFaturap) {
        this.idFaturap = idFaturap;
    }

    public Set<LinhaCateDto> getLinhasCate() {
        return linhasCate;
    }
    public void setLinhasCate(Set<LinhaCateDto> linhasCate) { this.linhasCate = linhasCate; }

    public Set<EncomendaDto> getEncomendas() {
        return encomendas;
    }
    public void setEncomendas(Set<EncomendaDto> encomendas) {
        this.encomendas = encomendas;
    }

    public Set<LinhaManuDto> getLinhasManu() {
        return linhasManu;
    }
    public void setLinhasManu(Set<LinhaManuDto> linhasManu) { this.linhasManu = linhasManu; }

}