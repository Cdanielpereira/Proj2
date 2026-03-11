package estg.ipvc.proj2.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Entity
@Table(name = "catering")
public class Catering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_catering", nullable = false)
    private Integer id;

    @ColumnDefault("0")
    @Column(name = "valorpagar", precision = 6, scale = 2)
    private BigDecimal valorpagar;

    @Column(name = "nhospedes", nullable = false)
    private Integer nhospedes;

    @Column(name = "preco_hosp", precision = 5, scale = 2)
    private BigDecimal precoHosp;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento idEvento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_colab", nullable = false)
    private Colaborador idColab;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_func", nullable = false)
    private Funcionario idFunc;

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

    public Integer getNhospedes() {
        return nhospedes;
    }

    public void setNhospedes(Integer nhospedes) {
        this.nhospedes = nhospedes;
    }

    public BigDecimal getPrecoHosp() {
        return precoHosp;
    }

    public void setPrecoHosp(BigDecimal precoHosp) {
        this.precoHosp = precoHosp;
    }

    public Evento getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Evento idEvento) {
        this.idEvento = idEvento;
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

}