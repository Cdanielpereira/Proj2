package estg.ipvc.proj2.dtos.EncomendaDto;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "encomenda")
public class EncomendaDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_enco", nullable = false)
    private Integer id;
    @Column(name = "valortotal", nullable = false, precision = 7, scale = 2)
    private BigDecimal valortotal;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_servico", nullable = false)
    private ServicoDto idServico;


    @OneToMany(mappedBy = "idEnco")
    private Set<LinhaEncDto> linhasEnc = new LinkedHashSet<>();


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

    public ServicoDto getIdServico() {
        return idServico;
    }
    public void setIdServico(ServicoDto idServico) {
        this.idServico = idServico;
    }

    public Set<LinhaEncDto> getLinhasEnc() {
        return linhasEnc;
    }
    public void setLinhasEnc(Set<LinhaEncDto> linhasEnc) {
        this.linhasEnc = linhasEnc;
    }

}
