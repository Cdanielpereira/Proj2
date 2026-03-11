package estg.ipvc.proj2.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "manutencao")
public class Manutencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_manutencao", nullable = false)
    private Integer id;

    @ColumnDefault("0")
    @Column(name = "valorpagar", precision = 6, scale = 2)
    private BigDecimal valorpagar;

    @Column(name = "dt_chegada")
    private LocalDate dtChegada;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_aviso", nullable = false)
    private Aviso idAviso;

    @Column(name = "id_zona", nullable = false)
    private Integer idZona;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_colab", nullable = false)
    private Colaborador idColab;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_func", nullable = false)
    private Funcionario idFunc;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento idEvento;

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

    public LocalDate getDtChegada() {
        return dtChegada;
    }

    public void setDtChegada(LocalDate dtChegada) {
        this.dtChegada = dtChegada;
    }

    public Aviso getIdAviso() {
        return idAviso;
    }

    public void setIdAviso(Aviso idAviso) {
        this.idAviso = idAviso;
    }

    public Integer getIdZona() {
        return idZona;
    }

    public void setIdZona(Integer idZona) {
        this.idZona = idZona;
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

    public Evento getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Evento idEvento) {
        this.idEvento = idEvento;
    }

}