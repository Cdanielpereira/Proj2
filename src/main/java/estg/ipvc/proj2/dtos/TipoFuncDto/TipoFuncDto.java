package estg.ipvc.proj2.dtos.TipoFuncDto;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tipo_func")
public class TipoFuncDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipofunc", nullable = false)
    private Integer id;

    @Column(name = "type", nullable = false, length = 20)
    private String type;

    @OneToMany(mappedBy = "idTipofunc")
    private Set<FuncionarioDto> funcionarios = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<FuncionarioDto> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Set<FuncionarioDto> funcionarios) {
        this.funcionarios = funcionarios;
    }

}
