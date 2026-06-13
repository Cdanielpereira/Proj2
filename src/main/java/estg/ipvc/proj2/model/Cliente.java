package estg.ipvc.proj2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", nullable = false)
    private Integer id;
    @Column(name = "nif")
    private Integer nif;
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    @Column(name = "dt_nasc")
    private LocalDate dtNasc;
    @Column(name = "rua", length = 50)
    private String rua;
    @Column(name = "porta", length = 20)
    private String porta;
    @Column(name = "sexo", length = 15)
    private String sexo;
    @Column(name = "email", length = 50)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user", nullable = false)
    private User idUser;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpostal")
    private Cpostal codPostal;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nacional")
    private Nacionalidade idNacional;

    @OneToMany(mappedBy = "idCliente")
    private Set<Marcacao> marcacaos = new LinkedHashSet<>();
}