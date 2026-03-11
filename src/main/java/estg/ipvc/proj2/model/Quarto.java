package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "quarto")
public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_quarto", nullable = false)
    private Integer id;

    @Column(name = "preco", precision = 6, scale = 2)
    private BigDecimal preco;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_zona", nullable = false)
    private Zona idZona;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipoquarto", nullable = false)
    private TipoQuarto idTipoquarto;

    @ManyToMany(mappedBy = "quartos")
    private Set<Marcacao> marcacaos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Zona getIdZona() {
        return idZona;
    }

    public void setIdZona(Zona idZona) {
        this.idZona = idZona;
    }

    public TipoQuarto getIdTipoquarto() {
        return idTipoquarto;
    }

    public void setIdTipoquarto(TipoQuarto idTipoquarto) {
        this.idTipoquarto = idTipoquarto;
    }

    public Set<Marcacao> getMarcacaos() {
        return marcacaos;
    }

    public void setMarcacaos(Set<Marcacao> marcacaos) {
        this.marcacaos = marcacaos;
    }

}