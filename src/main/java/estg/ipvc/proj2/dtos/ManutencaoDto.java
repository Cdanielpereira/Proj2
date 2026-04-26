package estg.ipvc.proj2.dtos;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "manutencao")
public class ManutencaoDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_manu", nullable = false)
    private Integer id;
    @Column(name = "descricao", length = 100)
    private String descricao;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_zona", nullable = false)
    private ZonaDto idZona;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idiva",  nullable = false)
    private TipoIVADto idiva;


    @OneToMany(mappedBy = "idManu")
    private Set<LinhaManuDto> linhasManu = new LinkedHashSet<>();


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

    public ZonaDto getIdZona() {
        return idZona;
    }
    public void setIdZona(ZonaDto idZona) {
        this.idZona = idZona;
    }

    public TipoIVADto getIdIVA() { return idiva; }
    public void setIdIVA(TipoIVADto idiva) {this.idiva = idiva;}

}