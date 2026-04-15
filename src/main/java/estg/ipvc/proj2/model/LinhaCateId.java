package estg.ipvc.proj2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LinhaCateId implements Serializable {
    @Serial
    private static final long serialVersionUID = -6553397947738776747L;

    @Column(name = "id_servico", nullable = false)
    private Integer idServico;
    @Column(name = "id_cate", nullable = false)
    private Integer idCate;


    public Integer getIdServico() {
        return idServico;
    }
    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    public Integer getIdCate() {
        return idCate;
    }
    public void setIdCate(Integer idCate) {
        this.idCate = idCate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinhaCateId entity = (LinhaCateId) o;
        return Objects.equals(this.idCate, entity.idCate) &&
                Objects.equals(this.idServico, entity.idServico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCate, idServico);
    }
}