package goodstay_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LinhaEncId implements Serializable {
    @Column(name = "id_enco", nullable = false)
    private Integer idEnco;
    @Column(name = "id_produto", nullable = false)
    private Integer idProduto;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof LinhaEncId)) return false;
        LinhaEncId that = (LinhaEncId) o;
        return Objects.equals(idEnco, that.idEnco) &&
                Objects.equals(idProduto, that.idProduto);
    }

    @Override
    public int hashCode() {return Objects.hash(idEnco, idProduto);}
}