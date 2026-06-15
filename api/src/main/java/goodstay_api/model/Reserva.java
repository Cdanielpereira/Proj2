package goodstay_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "reserva")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
    @EmbeddedId
    private ReservaId id;
    @Column(name = "precoatual", nullable = false, precision = 5, scale = 2)
    private BigDecimal precoatual;
    @Column(name = "ivaatual", nullable = false, precision = 3, scale = 2)
    private BigDecimal ivaatual;

    @MapsId("idMarc")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_marc", nullable = false)
    private Marcacao idMarc;
    @MapsId("nquarto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nquarto", nullable = false)
    private Quarto nquarto;
}