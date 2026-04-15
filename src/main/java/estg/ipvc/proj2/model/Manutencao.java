package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "manutencao")
public class Manutencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_manu", nullable = false)
    private Integer id;

    @Column(name = "descricao", length = 100)
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_zona", nullable = false)
    private Zona idZona;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idiva",  nullable = false)
    private TipoIVA idiva;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private LinhaManu linhaManu;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Zona getIdZona() {
        return idZona;
    }
    public void setIdZona(Zona idZona) {
        this.idZona = idZona;
    }

    public TipoIVA getIdIVA() { return idiva; }
    public void setIdIVA(TipoIVA idiva) {this.idiva = idiva;}

}