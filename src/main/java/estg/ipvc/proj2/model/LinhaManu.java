package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "linha_manu")
public class LinhaManu {
    @EmbeddedId
    private LinhaManuId id;
    @MapsId("idServico")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_servico", nullable = false)
    private Servico idServico;
    @MapsId("idManu")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_manu", nullable = false)
    private Manutencao idManu;
    @Column(name = "precoatual", nullable = false, precision = 5, scale = 2)
    private BigDecimal precoAtual;
    @Column(name = "ivaatual", nullable = false, precision = 3, scale = 2)
    private BigDecimal ivaAtual = idManu.getTipoIVA().getValor();


    public LinhaManuId getId() {
        return id;
    }
    public void setId(LinhaManuId id) {
        this.id = id;
    }

    public Servico getIdServico() {
        return idServico;
    }
    public void setIdServico(Servico idServico) {
        this.idServico = idServico;
    }

    public Manutencao getIdManu() {
        return idManu;
    }
    public void setIdManu(Manutencao idManu) {
        this.idManu = idManu;
    }

    public BigDecimal getPrecoAtual() {
        return precoAtual;
    }
    public void setPrecoatual(BigDecimal precoAtual) {
        this.precoAtual = precoAtual;
    }

    public BigDecimal getIvaAtual() {
        return ivaAtual;
    }
    public void setIvaAtual(BigDecimal ivaAtual) {
        this.ivaAtual = ivaAtual;
    }

}