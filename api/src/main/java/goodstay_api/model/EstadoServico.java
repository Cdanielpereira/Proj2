package goodstay_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "estado_servico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstadoServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estadoser", nullable = false)
    private Integer id;
    @Column(name = "state", nullable = false, length = 50)
    private String state;

    @OneToMany(mappedBy = "idEstadoser")
    private Set<Servico> servicos = new LinkedHashSet<>();
}