package estg.ipvc.proj2.dtos.LinhaManuDto;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "linha_manu")
public class LinhaManuDto {
    @EmbeddedId
    private LinhaManuId id;
    @MapsId("idManu")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_manu", nullable = false)
    private ManutencaoDto idManu;
    @MapsId("idServico")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_servico", nullable = false)
    private ServicoDto idServico;
    @Column(name = "precoatual", nullable = false, precision = 5, scale = 2)
    private BigDecimal precoatual;
    @Column(name = "ivaatual", nullable = false, precision = 3, scale = 2)
    private BigDecimal ivaatual = idManu.getIdIVA().getValor();


    public LinhaManuId getId() {
        return id;
    }
    public void setId(LinhaManuId id) {
        this.id = id;
    }

    public ServicoDto getIdServico() {
        return idServico;
    }
    public void setIdServico(ServicoDto idServico) {
        this.idServico = idServico;
    }

    public ManutencaoDto getIdManu() {
        return idManu;
    }
    public void setIdManu(ManutencaoDto idManu) {
        this.idManu = idManu;
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
