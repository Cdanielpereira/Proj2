package goodstay_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tipo_colab")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoColab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipocolab", nullable = false)
    private Integer id;
    @Column(name = "type", nullable = false, length = 50)
    private String type;

    @OneToMany(mappedBy = "idTipocolab")
    private Set<Colaborador> colaboradores = new LinkedHashSet<>();
}