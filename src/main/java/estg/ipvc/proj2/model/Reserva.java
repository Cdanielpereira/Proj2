package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "reserva")
public class Reserva {
    @EmbeddedId
    private ReservaId id;
    @MapsId("idMarc")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_marc", nullable = false)
    private Marcacao idMarc;
    @MapsId("nquarto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nquarto", nullable = false)
    private Quarto nquarto;
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

    public Marcacao getIdMarc() {
        return idMarc;
    }
    public void setIdMarc(Marcacao idMarc) {
        this.idMarc = idMarc;
    }

    public Quarto getNquarto() {
        return nquarto;
    }
    public void setNquarto(Quarto nquarto) {
        this.nquarto = nquarto;
    }

    public BigDecimal getPrecoatual() {
        return precoatual;
    }
    public void setPrecoatual(BigDecimal precoatual) {
        this.precoatual = precoatual;
    }

}