package estg.ipvc.proj2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cpostal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cpostal {
    @Id
    @Column(name = "cod_postal", nullable = false, length = 10)
    private String codPostal;
    @Column(name = "localidade", length = 100)
    private String localidade;

    @OneToMany(mappedBy = "cpostal")
    private Set<Cliente> clientes = new LinkedHashSet<>();
    @OneToMany(mappedBy = "cpostal")
    private Set<Colaborador> colaboradores = new LinkedHashSet<>();
}