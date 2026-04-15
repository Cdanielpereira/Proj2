package estg.ipvc.proj2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LinhaManuId implements Serializable {
    private static final long serialVersionUID = -1936886381190267140L;
    @Column(name = "id_manu", nullable = false)
    private Integer idManu;

    @Column(name = "id_servico", nullable = false)
    private Integer idServico;

    public Integer getIdManu() {
        return idManu;
    }
    public void setIdManu(Integer idManu) {
        this.idManu = idManu;
    }

    public Integer getIdServico() {
        return idServico;
    }
    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinhaManuId entity = (LinhaManuId) o;
        return Objects.equals(this.idManu, entity.idManu) &&
                Objects.equals(this.idServico, entity.idServico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idManu, idServico);
    }
}