package estg.ipvc.proj2.dtos.CateringDto;

import estg.ipvc.proj2.dtos.TipoIVADto.TipoIVADto;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "catering")
public class CateringDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cate", nullable = false)
    private Integer id;
    @Column(name = "nhospedes", nullable = false)
    private Integer nhospedes;
    @Column(name = "precohosp", nullable = false, precision = 7, scale = 2)
    private BigDecimal precohosp;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idiva",  nullable = false)
    private TipoIVADto idiva;

}
