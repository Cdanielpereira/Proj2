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
    @JoinColumn(name = "id_servico", nullable = false)
    private Servico idServico;

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

    public Servico getIdServico() {
        return idServico;
    }

    public void setIdServico(Servico idServico) {
        this.idServico = idServico;
    }

}