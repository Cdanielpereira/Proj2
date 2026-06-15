package goodstay_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LimpezaId implements Serializable {
    @Column(name = "id_zona", nullable = false)
    private Integer idZona;
    @Column(name = "id_func", nullable = false)
    private Integer idFunc;

    public Integer getIdZona() {return idZona;}
    public void setIdZona(Integer idZona) {this.idZona = idZona;}

    public Integer getIdFunc() {return idFunc;}
    public void setIdFunc(Integer idFunc) {this.idFunc = idFunc;}

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof LimpezaId)) return false;
        LimpezaId that = (LimpezaId) o;
        return Objects.equals(idZona, that.idZona) &&
                Objects.equals(idFunc, that.idFunc);
    }
    @Override
    public int hashCode() {return Objects.hash(idZona, idFunc);}
}