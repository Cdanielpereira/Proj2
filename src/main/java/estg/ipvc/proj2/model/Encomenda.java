package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "encomenda")
public class Encomenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_enco", nullable = false)
    private Integer id;

    @Column(name = "valortotal", nullable = false, precision = 7, scale = 2)
    private BigDecimal valortotal;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_servico", nullable = false)
    private Servico idServico;

    @OneToMany(mappedBy = "idEnco")
    private Set<LinhaEnc> linhasEnc = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValortotal() {
        return valortotal;
    }

    public void setValortotal(BigDecimal valortotal) {
        this.valortotal = valortotal;
    }

    public Servico getIdServico() {
        return idServico;
    }
    public void setIdServico(Servico idServico) {
        this.idServico = idServico;
    }

    public Set<LinhaEnc> getLinhaEncs() {
        return linhasEnc;
    }
    public void setLinhaEncs(Set<LinhaEnc> linhaEncs) {
        this.linhasEnc = linhaEncs;
    }

}