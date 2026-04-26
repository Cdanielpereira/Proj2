package estg.ipvc.proj2.dtos.CpostalDto;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cpostal")
public class CpostalDto {
    @Id
    @Column(name = "cod_postal", nullable = false, length = 10)
    private String codPostal;

    @Column(name = "localidade", nullable = false, length = 100)
    private String localidade;

    @OneToMany(mappedBy = "cpostal")
    private Set<ClienteDto> clientes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "cpostal")
    private Set<ColaboradorDto> colaboradors = new LinkedHashSet<>();

    @OneToMany(mappedBy = "cpostal")
    private Set<FuncionarioDto> funcionarios = new LinkedHashSet<>();

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public Set<ClienteDto> getClientes() {
        return clientes;
    }

    public void setClientes(Set<ClienteDto> clientes) {
        this.clientes = clientes;
    }

    public Set<ColaboradorDto> getColaboradors() {
        return colaboradors;
    }

    public void setColaboradors(Set<ColaboradorDto> colaboradors) {
        this.colaboradors = colaboradors;
    }

    public Set<FuncionarioDto> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Set<FuncionarioDto> funcionarios) {
        this.funcionarios = funcionarios;
    }

}
