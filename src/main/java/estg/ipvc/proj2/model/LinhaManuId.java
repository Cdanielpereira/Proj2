package estg.ipvc.proj2.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LinhaManuId implements Serializable {
    @Column(name = "id_manu", nullable = false)
    private Integer idManu;
    @Column(name = "id_servico", nullable = false)
    private Integer idServico;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof LinhaManuId)) return false;
        LinhaManuId that = (LinhaManuId) o;
        return Objects.equals(idManu, that.idManu) &&
                Objects.equals(idServico, that.idServico);
    }

    @Override
    public int hashCode() {return Objects.hash(idManu, idServico);}
}