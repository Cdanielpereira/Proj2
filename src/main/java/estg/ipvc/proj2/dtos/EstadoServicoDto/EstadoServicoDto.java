package estg.ipvc.proj2.dtos.EstadoServicoDto;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "estado_servico")
public class EstadoServicoDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estadoser", nullable = false)
    private Integer id;

    @Column(name = "state", nullable = false, length = 20)
    private String state;

    @OneToMany(mappedBy = "idEstadoser")
    private Set<ServicoDto> servicos = new LinkedHashSet<>();

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

    public Set<ServicoDto> getServicos() {
        return servicos;
    }

    public void setServicos(Set<ServicoDto> servicos) {
        this.servicos = servicos;
    }

}
