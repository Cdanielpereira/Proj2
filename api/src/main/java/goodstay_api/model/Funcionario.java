package goodstay_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "funcionario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_func", nullable = false)
    private Integer id;
    @Column(name = "iban", nullable = false, length = 30)
    private String iban;
    @Column(name = "nif", precision = 15)
    private BigDecimal nif;
    @Column(name = "rua", nullable = false, length = 50)
    private String rua;
    @Column(name = "porta", nullable = false, length = 20)
    private String porta;
    @Column(name = "dt_nasc", nullable = false)
    private LocalDate dtNasc;
    @Column(name = "sexo", nullable = false, length = 15)
    private String sexo;
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    @Column(name = "email", length = 50)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user", nullable = false)
    private User idUser;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipofunc", nullable = false)
    private TipoFunc idTipofunc;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cpostal", nullable = false)
    private Cpostal codPostal;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_nacional", nullable = false)
    private Nacionalidade idNacional;

    @OneToMany(mappedBy = "idFunc")
    private Set<Contrato> contratoes = new LinkedHashSet<>();
    @OneToMany(mappedBy = "idFunc")
    private Set<FaturaPagamento> faturaPagamentos = new LinkedHashSet<>();
    @OneToMany(mappedBy = "idFunc")
    private Set<Limpeza> limpezas = new LinkedHashSet<>();
    @OneToMany(mappedBy = "idFunc")
    private Set<Servico> servicos = new LinkedHashSet<>();
}