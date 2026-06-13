package estg.ipvc.proj2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "nacionalidade")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Nacionalidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nacional", nullable = false)
    private Integer id;
    @Column(name = "nacionalidade", nullable = false, length = 50)
    private String nacionalidade;

    @OneToMany(mappedBy = "idNacional")
    private Set<Cliente> clientes = new LinkedHashSet<>();
}