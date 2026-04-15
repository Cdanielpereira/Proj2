package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "linha_cate")
public class LinhaCate {
    @EmbeddedId
    private LinhaCateId id;

    @MapsId("idServico")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_servico", nullable = false)
    private Servico idServico;

    @MapsId("idCate")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cate", nullable = false)
    private Catering idCate;

    @Column(name = "precoatual", nullable = false, precision = 8, scale = 2)
    private BigDecimal precoatual;

    @Column(name = "ivaatual", nullable = false, precision = 7, scale = 2)
    private BigDecimal ivaatual;

    public LinhaCateId getId() {
        return id;
    }
    public void setId(LinhaCateId id) {
        this.id = id;
    }

    public Servico getIdServico() {
        return idServico;
    }
    public void setIdServico(Servico idServico) {
        this.idServico = idServico;
    }

    public Catering getIdCate() {
        return idCate;
    }
    public void setIdCate(Catering idCate) {
        this.idCate = idCate;
    }

    public BigDecimal getPrecoatual() {
        return precoatual;
    }
    public void setPrecoatual(BigDecimal precoatual) {
        this.precoatual = precoatual;
    }

    public BigDecimal getIvaatual() {
        return ivaatual;
    }
    public void setIvaatual(BigDecimal ivaatual) {
        this.ivaatual = ivaatual;
    }

}