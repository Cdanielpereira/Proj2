package goodstay_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tipo_zona")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoZona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipoz", nullable = false)
    private Integer id;
    @Column(name = "type", nullable = false, length = 20)
    private String type;

    @OneToMany(mappedBy = "idTipoz")
    private Set<Zona> zonas = new LinkedHashSet<>();
}