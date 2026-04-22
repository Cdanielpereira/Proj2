package estg.ipvc.proj2.dtos;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "reserva")
public class ReservaDto {
    @EmbeddedId
    private ReservaId id;
    @MapsId("idMarc")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_marc", nullable = false)
    private MarcacaoDto idMarc;
    @MapsId("nquarto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nquarto", nullable = false)
    private QuartoDto nquarto;
    @Column(name = "precoatual", nullable = false, precision = 5, scale = 2)
    private BigDecimal precoatual;
    @Column(name = "ivaatual", nullable = false, precision = 3, scale = 2)
    private BigDecimal ivaatual = nquarto.getIdTipoIVA().getValor();


    public ReservaId getId() {
        return id;
    }
    public void setId(ReservaId id) {
        this.id = id;
    }

    public MarcacaoDto getIdMarc() {
        return idMarc;
    }
    public void setIdMarc(MarcacaoDto idMarc) {
        this.idMarc = idMarc;
    }

    public QuartoDto getNquarto() {
        return nquarto;
    }
    public void setNquarto(QuartoDto nquarto) {
        this.nquarto = nquarto;
    }

    public BigDecimal getPrecoatual() {
        return precoatual;
    }
    public void setPrecoatual(BigDecimal precoatual) {
        this.precoatual = precoatual;
    }

}