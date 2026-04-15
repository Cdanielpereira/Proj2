package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

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
    @JoinColumn(name = "idiva", nullable = false)
    private TipoIVA idIVA;


    @OneToMany(mappedBy = "idManu")
    private Set<LinhaManu> linhasManu = new LinkedHashSet<>();


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

    public TipoIVA getTipoIVA() {
        return idIVA;
    }
    public void setTipoIVA(TipoIVA idIVA) {
        this.idIVA = idIVA;
    }

    public Set<LinhaManu> getLinhasManu() {
        return linhasManu;
    }
    public void setLinhasManu(Set<LinhaManu> linhasManu) {
        this.linhasManu = linhasManu;
    }

}