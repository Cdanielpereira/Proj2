package goodstay_api.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "catering")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Catering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cate", nullable = false)
    private Integer id;
    @Column(name = "nhospedes", nullable = false)
    private Integer nhospedes;
    @Column(name = "precohosp", nullable = false, precision = 7, scale = 2)
    private BigDecimal precohosp;
    @Column(name = "ivaatual", nullable = false, precision = 5, scale = 2)
    private BigDecimal ivaatual;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idiva", nullable = false)
    private TipoIVA idiva;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_servico", nullable = false)
    private Servico idServico;


    public void atualizarIvaDoTipo()
    {
        if (idiva != null) {this.ivaatual = idiva.getValor();}
    }
    public void setIvaAtual(BigDecimal novoValor)
    {
        this.ivaatual = novoValor;
    }
}