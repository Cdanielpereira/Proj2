package estg.ipvc.proj2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ReservaId implements Serializable {
    @Serial
    private static final long serialVersionUID = -9131240224969471251L;
    @Column(name = "id_marc", nullable = false)
    private Integer idMarc;
    @Column(name = "nquarto", nullable = false)
    private Integer nQuarto;


    public Integer getIdMarc() {
        return idMarc;
    }
    public void setIdMarc(Integer idMarc) {
        this.idMarc = idMarc;
    }

    public Integer getNQuarto() {
        return nQuarto;
    }
    public void setNQuarto(Integer nQuarto) {
        this.nQuarto = nQuarto;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservaId entity = (ReservaId) o;
        return Objects.equals(this.idMarc, entity.idMarc) &&
                Objects.equals(this.nQuarto, entity.nQuarto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMarc, nQuarto);
    }
}