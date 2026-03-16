package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "limpeza")
public class Limpeza {
    @EmbeddedId
    private LimpezaId id;

    @MapsId("idZona")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_zona", nullable = false)
    private Zona idZona;

    @MapsId("idFunc")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_func", nullable = false)
    private Funcionario idFunc;

    @Column(name = "dt_reali", nullable = false)
    private LocalDate dtReali;

    public LimpezaId getId() {
        return id;
    }

    public void setId(LimpezaId id) {
        this.id = id;
    }

    public Zona getIdZona() {
        return idZona;
    }

    public void setIdZona(Zona idZona) {
        this.idZona = idZona;
    }

    public Funcionario getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(Funcionario idFunc) {
        this.idFunc = idFunc;
    }

    public LocalDate getDtReali() {
        return dtReali;
    }

    public void setDtReali(LocalDate dtReali) {
        this.dtReali = dtReali;
    }

}