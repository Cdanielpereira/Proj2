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
    @MapsId("nQuarto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nquarto", nullable = false)
    private Quarto nQuarto;
    @Column(name = "precoatual", nullable = false, precision = 5, scale = 2)
    private BigDecimal precoAtual;
    @Column(name = "ivaatual", nullable = false, precision = 3, scale = 2)
    private BigDecimal ivaAtual = nQuarto.getTipoIVA().getValor();


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
        return nQuarto;
    }
    public void setNQuarto(Quarto nQuarto) {
        this.nQuarto = nQuarto;
    }

    public BigDecimal getPrecoAtual() {
        return precoAtual;
    }
    public void setPrecoAtual(BigDecimal precoAtual) {
        this.precoAtual = precoAtual;
    }

}