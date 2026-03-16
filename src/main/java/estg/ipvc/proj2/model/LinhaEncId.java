package estg.ipvc.proj2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LinhaEncId implements Serializable {
    private static final long serialVersionUID = -1936886381190267140L;
    @Column(name = "id_enco", nullable = false)
    private Integer idEnco;

    @Column(name = "id_produto", nullable = false)
    private Integer idProduto;

    public Integer getIdEnco() {
        return idEnco;
    }

    public void setIdEnco(Integer idEnco) {
        this.idEnco = idEnco;
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
        if (o == null || getClass() != o.getClass()) return false;
        LinhaEncId entity = (LinhaEncId) o;
        return Objects.equals(this.idEnco, entity.idEnco) &&
                Objects.equals(this.idProduto, entity.idProduto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEnco, idProduto);
    }
}