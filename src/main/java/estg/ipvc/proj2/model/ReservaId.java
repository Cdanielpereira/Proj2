package estg.ipvc.proj2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ReservaId implements Serializable {
    private static final long serialVersionUID = 9080700975844060409L;
    @Column(name = "id_marcacao", nullable = false)
    private Integer idMarcacao;

    @Column(name = "id_quarto", nullable = false)
    private Integer idQuarto;

    public Integer getIdMarcacao() {
        return idMarcacao;
    }

    public void setIdMarcacao(Integer idMarcacao) {
        this.idMarcacao = idMarcacao;
    }

    public Integer getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(Integer idQuarto) {
        this.idQuarto = idQuarto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ReservaId entity = (ReservaId) o;
        return Objects.equals(this.idMarcacao, entity.idMarcacao) &&
                Objects.equals(this.idQuarto, entity.idQuarto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMarcacao, idQuarto);
    }

}