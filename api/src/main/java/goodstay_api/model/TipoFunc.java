package goodstay_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tipo_func")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoFunc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipofunc", nullable = false)
    private Integer id;
    @Column(name = "type", nullable = false, length = 20)
    private String type;

    @OneToMany(mappedBy = "idTipofunc")
    private Set<Funcionario> funcionarios = new LinkedHashSet<>();
}