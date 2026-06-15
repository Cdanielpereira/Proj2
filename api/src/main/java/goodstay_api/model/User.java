package goodstay_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"user\"")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Integer id;
    @Column(name = "username", nullable = false, length = 100)
    private String username;
    @Column(name = "password", nullable = false, length = 20)
    private String password;
    @Column(name = "telefone", nullable = false, length = 15)
    private String telefone;

    @OneToMany(mappedBy = "idUser")
    private Set<Cliente> clientes = new LinkedHashSet<>();
    @OneToMany(mappedBy = "idUser")
    private Set<Funcionario> funcionarios = new LinkedHashSet<>();
}   