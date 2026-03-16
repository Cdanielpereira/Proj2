package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cpostal")
public class Cpostal {
    @Id
    @Column(name = "cod_postal", nullable = false, length = 10)
    private String codPostal;

    @Column(name = "localidade", nullable = false, length = 100)
    private String localidade;

    @OneToMany(mappedBy = "cpostal")
    private Set<Cliente> clientes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "cpostal")
    private Set<Colaborador> colaboradors = new LinkedHashSet<>();

    @OneToMany(mappedBy = "cpostal")
    private Set<Funcionario> funcionarios = new LinkedHashSet<>();

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

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Set<Colaborador> getColaboradors() {
        return colaboradors;
    }

    public void setColaboradors(Set<Colaborador> colaboradors) {
        this.colaboradors = colaboradors;
    }

    public Set<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

}