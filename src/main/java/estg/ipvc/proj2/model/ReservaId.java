package estg.ipvc.proj2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ReservaId implements Serializable {
    private static final long serialVersionUID = -9131240224969471251L;
    @Column(name = "id_marc", nullable = false)
    private Integer idMarc;

    @Column(name = "nquarto", nullable = false)
    private Integer nquarto;

    public Integer getIdMarc() {
        return idMarc;
    }

    public void setIdMarc(Integer idMarc) {
        this.idMarc = idMarc;
    }

    public Integer getNquarto() {
        return nquarto;
    }

    public void setNquarto(Integer nquarto) {
        this.nquarto = nquarto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservaId entity = (ReservaId) o;
        return Objects.equals(this.idMarc, entity.idMarc) &&
                Objects.equals(this.nquarto, entity.nquarto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMarc, nquarto);
    }
}