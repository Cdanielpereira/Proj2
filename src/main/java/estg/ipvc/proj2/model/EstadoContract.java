package estg.ipvc.proj2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "estado_contract")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstadoContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estadoc", nullable = false)
    private Integer id;
    @Column(name = "state", nullable = false, length = 20)
    private String state;

    @OneToMany(mappedBy = "idEstadoc")
    private Set<Contrato> contratoes = new LinkedHashSet<>();
}