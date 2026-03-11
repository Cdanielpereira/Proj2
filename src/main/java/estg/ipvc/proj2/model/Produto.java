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

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "qtd_stock", nullable = false, precision = 6, scale = 2)
    private BigDecimal qtdStock;

    @OneToMany(mappedBy = "idProduto")
    private Set<Aviso> avisos = new LinkedHashSet<>();

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

    public BigDecimal getQtdStock() {
        return qtdStock;
    }

    public void setQtdStock(BigDecimal qtdStock) {
        this.qtdStock = qtdStock;
    }

    public Set<Aviso> getAvisos() {
        return avisos;
    }

    public void setAvisos(Set<Aviso> avisos) {
        this.avisos = avisos;
    }

    public Set<LinhaEnc> getLinhaEncs() {
        return linhaEncs;
    }

    public void setLinhaEncs(Set<LinhaEnc> linhaEncs) {
        this.linhaEncs = linhaEncs;
    }

}