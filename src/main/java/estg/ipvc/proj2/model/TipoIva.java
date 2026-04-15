package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tipo_iva")
public class TipoIva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idiva", nullable = false)
    private Integer id;
    @Column(name = "type", nullable = false, length = 20)
    private String type;
    @Column(name = "valor", nullable = false, precision = 7, scale = 2)
    private BigDecimal valor;


    @OneToMany(mappedBy = "idiva")
    private Set<Quarto> quartos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idiva")
    private Set<Produto> produtos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idiva")
    private Set<Catering> caterings = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idiva")
    private Set<Manutencao> manutencaos = new LinkedHashSet<>();


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

    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Set<Catering> getCaterings() {
        return caterings;
    }
    public void setCaterings(Set<Catering> caterings) {
        this.caterings = caterings;
    }

    public Set<Manutencao> getManutencaos() {
        return manutencaos;
    }
    public void setManutencaos(Set<Manutencao> manutencaos) {
        this.manutencaos = manutencaos;
    }

}