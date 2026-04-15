package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tipo_iva")
public class TipoIVA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idiva", nullable = false)
    private Integer id;

    @Column(name = "type", nullable = false, length = 20)
    private String type;

    @Column(name = "valor", nullable = false, precision = 5, scale = 2 )
    private BigDecimal valor;

    @OneToMany(mappedBy = "idiva")
    private Set<Quarto> quartos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idiva")
    private Set<Produto> produtos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idiva")
    private Set<Manutencao> manutencoes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idiva")
    private Set<Catering> caterings = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public Set<Quarto> getQuartos() {
        return quartos;
    }
    public void setQuartos(Set<Quarto> quartos) {
        this.quartos = quartos;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }
    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    public Set<Manutencao> getManutencoes() {
        return manutencoes;
    }
    public void setManutencoes(Set<Manutencao> manutencoes) {
        this.manutencoes = manutencoes;
    }

    public Set<Catering> getCaterings() {
        return caterings;
    }
    public void setCaterings(Set<Catering> caterings) {
        this.caterings = caterings;
    }

}