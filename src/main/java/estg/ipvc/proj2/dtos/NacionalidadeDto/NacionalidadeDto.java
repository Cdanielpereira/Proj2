package estg.ipvc.proj2.dtos.NacionalidadeDto;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "nacionalidade")
public class NacionalidadeDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nacional", nullable = false)
    private Integer id;

    @Column(name = "nacionalidade", nullable = false, length = 30)
    private String nacionalidade;

    @OneToMany(mappedBy = "idNacional")
    private Set<ClienteDto> clientes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idNacional")
    private Set<FuncionarioDto> funcionarios = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Set<ClienteDto> getClientes() {
        return clientes;
    }

    public void setClientes(Set<ClienteDto> clientes) {
        this.clientes = clientes;
    }

    public Set<FuncionarioDto> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Set<FuncionarioDto> funcionarios) {
        this.funcionarios = funcionarios;
    }

}
