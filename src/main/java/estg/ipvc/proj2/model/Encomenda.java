package estg.ipvc.proj2.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "encomenda")
public class Encomenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_encomenda", nullable = false)
    private Integer id;

    @ColumnDefault("0")
    @Column(name = "precototal", precision = 6, scale = 2)
    private BigDecimal precototal;

    @Column(name = "dt_chegada")
    private LocalDate dtChegada;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_colab", nullable = false)
    private Colaborador idColab;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_func", nullable = false)
    private Funcionario idFunc;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento idEvento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_aviso", nullable = false)
    private Aviso idAviso;

    @OneToMany(mappedBy = "idEncomenda")
    private Set<LinhaEnc> linhaEncs = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrecototal() {
        return precototal;
    }

    public void setPrecototal(BigDecimal precototal) {
        this.precototal = precototal;
    }

    public LocalDate getDtChegada() {
        return dtChegada;
    }

    public void setDtChegada(LocalDate dtChegada) {
        this.dtChegada = dtChegada;
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

    public Aviso getIdAviso() {
        return idAviso;
    }

    public void setIdAviso(Aviso idAviso) {
        this.idAviso = idAviso;
    }

    public Set<LinhaEnc> getLinhaEncs() {
        return linhaEncs;
    }

    public void setLinhaEncs(Set<LinhaEnc> linhaEncs) {
        this.linhaEncs = linhaEncs;
    }

}