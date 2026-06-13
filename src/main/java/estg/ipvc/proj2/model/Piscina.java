package estg.ipvc.proj2.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "piscina")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Piscina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_piscina", nullable = false)
    private Integer id;
    @Column(name = "ph", precision = 10, scale = 2)
    private BigDecimal ph;
    @Column(name = "temp", precision = 100, scale = 2)
    private BigDecimal temp;
    @Column(name = "volume", nullable = false, precision = 4, scale = 2)
    private BigDecimal volume;
    @Column(name = "nivel_cl", precision = 5, scale = 2)
    private BigDecimal nivelCl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_zona")
    private Zona idZona;
}