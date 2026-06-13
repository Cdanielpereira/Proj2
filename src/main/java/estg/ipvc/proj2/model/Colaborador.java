package estg.ipvc.proj2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "colaborador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_colab", nullable = false)
    private Integer id;
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    @Column(name = "telefone", nullable = false, length = 15)
    private String telefone;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "rua", nullable = false, length = 50)
    private String rua;
    @Column(name = "nporta", nullable = false, length = 20)
    private String nporta;
    @Column(name = "iban", length = 30)
    private String iban;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipocolab", nullable = false)
    private TipoColab idTipocolab;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cpostal", nullable = false)
    private Cpostal codPostal;

    @OneToMany(mappedBy = "idColab")
    private Set<Servico> servicos = new LinkedHashSet<>();
}