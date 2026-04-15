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
    private Integer qtdStock;
    @Column(name = "qtdmin")
    private Integer qtdMin;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idiva", nullable = false)
    private TipoIVA idIVA;


    @OneToMany(mappedBy = "idProduto")
    private Set<LinhaEnc> linhasEnc = new LinkedHashSet<>();


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

    public Integer getQtdStock() {
        return qtdStock;
    }
    public void setQtdStock(Integer qtdStock) {
        this.qtdStock = qtdStock;
    }

    public Integer getQtdMin() {
        return qtdMin;
    }
    public void setQtdMin(Integer qtdMin) {
        this.qtdMin = qtdMin;
    }

    public TipoIVA getTipoIVA() {
        return idIVA;
    }
    public void setTipoIVA(TipoIVA idIVA) {this.idIVA = idIVA;}

    public Set<LinhaEnc> getLinhasEnc() {
        return linhasEnc;
    }
    public void setLinhasEnc(Set<LinhaEnc> linhasEnc) {
        this.linhasEnc = linhasEnc;
    }

}