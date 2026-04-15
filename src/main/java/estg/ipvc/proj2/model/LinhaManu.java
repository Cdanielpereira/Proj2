package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "linha_manu")
public class LinhaManu {
    @EmbeddedId
    private LinhaManuId id;

    @MapsId("idEnco")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_manu", nullable = false)
    private Manutencao idManu;

    @MapsId("idServico")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_servico", nullable = false)
    private Servico idServico;

    @Column(name = "precoatual", nullable = false, precision = 5, scale = 2)
    private BigDecimal precoatual;

    @Column(name = "ivaatual", nullable = false, precision = 5, scale = 2)
    private BigDecimal ivaatual = idManu.getIdIVA().getValor();

    public LinhaManuId getId() {
        return id;
    }
    public void setId(LinhaManuId id) {
        this.id = id;
    }

    public Manutencao getIdManu() {
        return idManu;
    }
    public void setIdManu(Manutencao idManu) {
        this.idManu = idManu;
    }

    public Servico getIdServico() {
        return idServico;
    }
    public void setIdServico(Servico idServico) {
        this.idServico = idServico;
    }

    public BigDecimal getPrecoatual() {
        return precoatual;
    }
    public void setPrecoatual(BigDecimal precoatual) {
        this.precoatual = precoatual;
    }

    public BigDecimal getIvaatual() { return ivaatual; }
    public void setIvaatual(BigDecimal ivaatual) {}
}