package goodstay_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "marcacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Marcacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marc", nullable = false)
    private Integer id;
    @Column(name = "dt_marc", nullable = false)
    private LocalDate dtMarc;
    @Column(name = "dt_fim", nullable = false)
    private LocalDate dtFim;
    @Column(name = "dt_checkin")
    private LocalDate dtCheckin;
    @Column(name = "dt_checkout")
    private LocalDate dtCheckout;
    @Column(name = "valort", nullable = false, precision = 1000, scale = 2)
    private BigDecimal valort;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estadom", nullable = false)
    private EstadoMarcacao idEstadom;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente idCliente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "if_faturar")
    private FaturaRecibo ifFaturar;

    @OneToMany(mappedBy = "idMarc")
    private Set<Reserva> reservas = new LinkedHashSet<>();
}