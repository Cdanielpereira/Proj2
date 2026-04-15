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
    @Column(name = "precoatual", nullable = false, precision = 5, scale = 2)
    private BigDecimal precoAtual;

    @Column(name = "ivaatual", nullable = false, precision = 3, scale = 2)
    private BigDecimal ivaAtual = idCate.getTipoIVA().getValor();


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

    public BigDecimal getPrecoAtual() {
        return precoAtual;
    }
    public void setPrecoAtual(BigDecimal precoAtual) {
        this.precoAtual = precoAtual;
    }

    public BigDecimal getIVAAtual() {
        return ivaAtual;
    }
    public void setIVAAtual(BigDecimal ivaAtual) {
        this.ivaAtual = ivaAtual;
    }

}