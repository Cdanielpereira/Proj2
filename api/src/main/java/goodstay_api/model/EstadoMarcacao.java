package goodstay_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "estado_marcacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstadoMarcacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estadom", nullable = false)
    private Integer id;
    @Column(name = "state", nullable = false, length = 100)
    private String state;

    @OneToMany(mappedBy = "idEstadom")
    private Set<Marcacao> marcacaos = new LinkedHashSet<>();
}