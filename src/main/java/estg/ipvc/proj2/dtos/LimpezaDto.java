package estg.ipvc.proj2.dtos;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "limpeza")
public class LimpezaDto {
    @EmbeddedId
    private LimpezaId id;

    @MapsId("idZona")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_zona", nullable = false)
    private ZonaDto idZona;

    @MapsId("idFunc")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_func", nullable = false)
    private FuncionarioDto idFunc;

    @Column(name = "dt_reali", nullable = false)
    private LocalDate dtReali;

    public LimpezaId getId() {
        return id;
    }

    public void setId(LimpezaId id) {
        this.id = id;
    }

    public ZonaDto getIdZona() {
        return idZona;
    }

    public void setIdZona(ZonaDto idZona) {
        this.idZona = idZona;
    }

    public FuncionarioDto getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(FuncionarioDto idFunc) {
        this.idFunc = idFunc;
    }

    public LocalDate getDtReali() {
        return dtReali;
    }

    public void setDtReali(LocalDate dtReali) {
        this.dtReali = dtReali;
    }

}