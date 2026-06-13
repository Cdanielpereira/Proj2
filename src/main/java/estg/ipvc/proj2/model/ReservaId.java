package estg.ipvc.proj2.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservaId implements Serializable {
    @Column(name = "id_marc", nullable = false)
    private Integer idMarc;
    @Column(name = "nquarto", nullable = false)
    private Integer nquarto;
}