package estg.ipvc.proj2.dtos.EstadoContractDto;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "estado_contract")
public class EstadoContractDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estadoc", nullable = false)
    private Integer id;

    @Column(name = "state", nullable = false, length = 20)
    private String state;

    @OneToMany(mappedBy = "idEstadoc")
    private Set<ContratoDto> contratoes = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Set<ContratoDto> getContratoes() {
        return contratoes;
    }

    public void setContratoes(Set<ContratoDto> contratoes) {
        this.contratoes = contratoes;
    }

}
