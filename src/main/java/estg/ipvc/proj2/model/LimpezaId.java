package estg.ipvc.proj2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class LimpezaId implements Serializable {
    private static final long serialVersionUID = 2354051763392700770L;
    @Column(name = "id_zona", nullable = false)
    private Integer idZona;

    @Column(name = "id_func", nullable = false)
    private Integer idFunc;

    @Column(name = "dt_real", nullable = false)
    private LocalDate dtReal;

    public Integer getIdZona() {
        return idZona;
    }

    public void setIdZona(Integer idZona) {
        this.idZona = idZona;
    }

    public Integer getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(Integer idFunc) {
        this.idFunc = idFunc;
    }

    public LocalDate getDtReal() {
        return dtReal;
    }

    public void setDtReal(LocalDate dtReal) {
        this.dtReal = dtReal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LimpezaId entity = (LimpezaId) o;
        return Objects.equals(this.idFunc, entity.idFunc) &&
                Objects.equals(this.dtReal, entity.dtReal) &&
                Objects.equals(this.idZona, entity.idZona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFunc, dtReal, idZona);
    }

}