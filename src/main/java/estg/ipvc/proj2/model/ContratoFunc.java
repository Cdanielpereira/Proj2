package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "contrato_func")
public class ContratoFunc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contf", nullable = false)
    private Integer id;

    @Column(name = "remuneracao", nullable = false, precision = 6, scale = 2)
    private BigDecimal remuneracao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_contrato", nullable = false)
    private Contrato idContrato;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_func", nullable = false)
    private Funcionario idFunc;

    @OneToMany(mappedBy = "idContf")
    private Set<Vencimento> vencimentos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getRemuneracao() {
        return remuneracao;
    }

    public void setRemuneracao(BigDecimal remuneracao) {
        this.remuneracao = remuneracao;
    }

    public Contrato getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Contrato idContrato) {
        this.idContrato = idContrato;
    }

    public Funcionario getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(Funcionario idFunc) {
        this.idFunc = idFunc;
    }

    public Set<Vencimento> getVencimentos() {
        return vencimentos;
    }

    public void setVencimentos(Set<Vencimento> vencimentos) {
        this.vencimentos = vencimentos;
    }

}