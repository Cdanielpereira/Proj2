package estg.ipvc.proj2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "reserva")
public class Reserva {
    @EmbeddedId
    private ReservaId id;

    @MapsId("idMarcacao")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_marcacao", nullable = false)
    private Marcacao idMarcacao;

    @MapsId("idQuarto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_quarto", nullable = false)
    private Quarto idQuarto;

    public ReservaId getId() {
        return id;
    }

    public void setId(ReservaId id) {
        this.id = id;
    }

    public Marcacao getIdMarcacao() {
        return idMarcacao;
    }

    public void setIdMarcacao(Marcacao idMarcacao) {
        this.idMarcacao = idMarcacao;
    }

    public Quarto getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(Quarto idQuarto) {
        this.idQuarto = idQuarto;
    }

}