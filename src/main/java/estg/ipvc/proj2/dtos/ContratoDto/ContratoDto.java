package estg.ipvc.proj2.dtos.ContratoDto;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "contrato")
public class ContratoDto {
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
    private FuncionarioDto idFunc;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estadoc", nullable = false)
    private EstadoContractDto idEstadoc;

    @OneToMany(mappedBy = "idContrato")
    private Set<VencimentoDto> vencimentos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public LocalDate getDtCriado() {
        return dtCriado;
    }

    public void setDtCriado(LocalDate dtCriado) {
        this.dtCriado = dtCriado;
    }

    public LocalDate getDtAssinado() {
        return dtAssinado;
    }

    public void setDtAssinado(LocalDate dtAssinado) {
        this.dtAssinado = dtAssinado;
    }

    public LocalDate getDtIni() {
        return dtIni;
    }

    public void setDtIni(LocalDate dtIni) {
        this.dtIni = dtIni;
    }

    public LocalDate getDtFim() {
        return dtFim;
    }

    public void setDtFim(LocalDate dtFim) {
        this.dtFim = dtFim;
    }

    public FuncionarioDto getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(FuncionarioDto idFunc) {
        this.idFunc = idFunc;
    }

    public EstadoContractDto getIdEstadoc() {
        return idEstadoc;
    }

    public void setIdEstadoc(EstadoContractDto idEstadoc) {
        this.idEstadoc = idEstadoc;
    }

    public Set<VencimentoDto> getVencimentos() {
        return vencimentos;
    }

    public void setVencimentos(Set<VencimentoDto> vencimentos) {
        this.vencimentos = vencimentos;
    }

}
