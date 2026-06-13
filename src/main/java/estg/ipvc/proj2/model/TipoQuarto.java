package estg.ipvc.proj2.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tipo_quarto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoQuarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipoq", nullable = false)
    private Integer id;
    @Column(name = "type", nullable = false, length = 20)
    private String type;

    @OneToMany(mappedBy = "idTipoq")
    private Set<Quarto> quartos = new LinkedHashSet<>();
}