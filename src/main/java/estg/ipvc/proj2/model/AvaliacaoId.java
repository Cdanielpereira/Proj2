package estg.ipvc.proj2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AvaliacaoId implements Serializable {
    private static final long serialVersionUID = -1468555297726840599L;
    @Column(name = "id_func", nullable = false)
    private Integer idFunc;

    @Column(name = "id_cand", nullable = false)
    private Integer idCand;

    public Integer getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(Integer idFunc) {
        this.idFunc = idFunc;
    }

    public Integer getIdCand() {
        return idCand;
    }

    public void setIdCand(Integer idCand) {
        this.idCand = idCand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AvaliacaoId entity = (AvaliacaoId) o;
        return Objects.equals(this.idFunc, entity.idFunc) &&
                Objects.equals(this.idCand, entity.idCand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFunc, idCand);
    }

}