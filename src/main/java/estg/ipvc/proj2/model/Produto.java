package estg.ipvc.proj2.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto", nullable = false)
    private Integer id;
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    @Column(name = "valor", nullable = false, precision = 5, scale = 2)
    private BigDecimal valor;
    @Column(name = "qtdstock", nullable = false)
    private Integer qtdstock;
    @Column(name = "qtdmin")
    private Integer qtdmin;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idiva", nullable = false)
    private TipoIVA idiva;

    @OneToMany(mappedBy = "idProduto")
    private Set<LinhaEnc> linhaEncs = new LinkedHashSet<>();
}