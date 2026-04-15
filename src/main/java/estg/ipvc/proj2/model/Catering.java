package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@SuppressWarnings("SpellCheckingInspection")
@Entity
@Table(name = "catering")
public class Catering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cate", nullable = false)
    private Integer id;
    @Column(name = "nhospedes", nullable = false)
    private Integer nHospedes;
    @Column(name = "precohosp", nullable = false, precision = 7, scale = 2)
    private BigDecimal precoHosp;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idiva",  nullable = false)
    private TipoIVA idIVA;


    @OneToMany(mappedBy = "idCate")
    private Set<LinhaCate> linhasCate = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNHospedes() {
        return nHospedes;
    }
    public void setNHospedes(Integer nHospedes) {
        this.nHospedes = nHospedes;
    }

    public BigDecimal getPrecoHosp() {
        return precoHosp;
    }
    public void setPrecoHosp(BigDecimal precoHosp) {
        this.precoHosp = precoHosp;
    }

    public TipoIVA getTipoIVA() { return idIVA; }
    public void setTipoIVA(TipoIVA idIVA) {this.idIVA = idIVA;}

    public Set<LinhaCate> getLinhaCate() {
        return linhasCate;
    }
    public void setLinhasCate(Set<LinhaCate> linhasCate) {
        this.linhasCate = linhasCate;
    }
}