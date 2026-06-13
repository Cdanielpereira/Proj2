package estg.ipvc.proj2.model;

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
    @Column(name = "designacao", nullable = false, length = 50)
    private String designacao;

    @OneToMany(mappedBy = "idTipocolab")
    private Set<Colaborador> colaboradores = new LinkedHashSet<>();
}