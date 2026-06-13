package estg.ipvc.proj2.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "linha_enc")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LinhaEnc {
    @EmbeddedId
    private LinhaEncId id;
    @Column(name = "precoatual", nullable = false, precision = 5, scale = 2)
    private BigDecimal precoatual;
    @Column(name = "qtd", nullable = false)
    private Integer qtd;
    // SNAPSHOT DO IVA (correto)
    @Column(name = "ivaatual", nullable = false, precision = 3, scale = 2)
    private BigDecimal ivaatual;

    @MapsId("idEnco")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_enco", nullable = false)
    private Encomenda idEnco;
    @MapsId("idProduto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto idProduto;
}