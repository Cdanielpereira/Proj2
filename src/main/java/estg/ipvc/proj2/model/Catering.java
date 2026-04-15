package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "catering")
public class Catering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cate", nullable = false)
    private Integer id;
    @Column(name = "nhospedes", nullable = false)
    private Integer nhospedes;
    @Column(name = "precohosp", nullable = false, precision = 7, scale = 2)
    private BigDecimal precohosp;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idiva",  nullable = false)
    private TipoIVA idiva;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNhospedes() {
        return nhospedes;
    }
    public void setNhospedes(Integer nhospedes) {
        this.nhospedes = nhospedes;
    }

    public BigDecimal getPrecohosp() {
        return precohosp;
    }
    public void setPrecohosp(BigDecimal precohosp) {
        this.precohosp = precohosp;
    }

    public TipoIVA getTipoIVA() { return idiva; }
    public void setTipoIVA(TipoIVA idiva) {this.idiva = idiva;}

}