package estg.ipvc.proj2.dtos;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "linha_cate")
public class LinhaCateDto {
    @EmbeddedId
    private LinhaCateId id;
    @MapsId("idCate")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cate", nullable = false)
    private CateringDto idCate;
    @MapsId("idServico")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_servico", nullable = false)
    private ServicoDto idServico;
    @Column(name = "precoatual", nullable = false, precision = 5, scale = 2)
    private BigDecimal precoatual;
    @Column(name = "ivaatual", nullable = false, precision = 3, scale = 2)
    private BigDecimal ivaatual = idCate.getTipoIVA().getValor();


    public LinhaCateId getId() {
        return id;
    }
    public void setId(LinhaCateId id) {
        this.id = id;
    }

    public ServicoDto getIdServico() {
        return idServico;
    }
    public void setIdServico(ServicoDto idServico) {
        this.idServico = idServico;
    }

    public CateringDto getIdCate() {
        return idCate;
    }
    public void setIdCate(CateringDto idCate) {
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