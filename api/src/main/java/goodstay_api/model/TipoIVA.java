package goodstay_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tipo_iva")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoIVA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idiva", nullable = false)
    private Integer id;
    @Column(name = "type", nullable = false, length = 20)
    private String type;
    @Column(name = "valor", nullable = false, precision = 5, scale = 2)
    private BigDecimal valor;
    @OneToMany(mappedBy = "idiva")
    private Set<Quarto> quartos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idiva")
    private Set<Produto> produtos = new LinkedHashSet<>();
    @OneToMany(mappedBy = "idiva")
    private Set<Manutencao> manutencoes = new LinkedHashSet<>();
    @OneToMany(mappedBy = "idiva")
    private Set<Catering> caterings = new LinkedHashSet<>();
}