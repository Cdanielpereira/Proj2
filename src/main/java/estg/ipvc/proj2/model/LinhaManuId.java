package estg.ipvc.proj2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LinhaManuId implements Serializable {
    private static final long serialVersionUID = 6479956131203142450L;
    @Column(name = "id_servico", nullable = false)
    private Integer idServico;

    @Column(name = "id_manu", nullable = false)
    private Integer idManu;

    public Integer getIdServico() {
        return idServico;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    public Integer getIdManu() {
        return idManu;
    }

    public void setIdManu(Integer idManu) {
        this.idManu = idManu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinhaManuId entity = (LinhaManuId) o;
        return Objects.equals(this.idServico, entity.idServico) &&
                Objects.equals(this.idManu, entity.idManu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idServico, idManu);
    }
}