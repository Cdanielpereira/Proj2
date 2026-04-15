package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "produto")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getQtdstock() {
        return qtdstock;
    }

    public void setQtdstock(Integer qtdstock) {
        this.qtdstock = qtdstock;
    }

    public Integer getQtdmin() {
        return qtdmin;
    }

    public void setQtdmin(Integer qtdmin) {
        this.qtdmin = qtdmin;
    }

    public Set<LinhaEnc> getLinhaEncs() {
        return linhaEncs;
    }

    public void setLinhaEncs(Set<LinhaEnc> linhaEncs) {
        this.linhaEncs = linhaEncs;
    }

}