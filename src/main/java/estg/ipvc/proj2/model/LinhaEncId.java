package estg.ipvc.proj2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LinhaEncId implements Serializable {
    private static final long serialVersionUID = 2176334043762295905L;
    @Column(name = "id_encomenda", nullable = false)
    private Integer idEncomenda;

    @Column(name = "id_produto", nullable = false)
    private Integer idProduto;

    public Integer getIdEncomenda() {
        return idEncomenda;
    }

    public void setIdEncomenda(Integer idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LinhaEncId entity = (LinhaEncId) o;
        return Objects.equals(this.idEncomenda, entity.idEncomenda) &&
                Objects.equals(this.idProduto, entity.idProduto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEncomenda, idProduto);
    }

}