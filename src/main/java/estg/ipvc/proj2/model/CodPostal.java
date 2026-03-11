package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cod_postal")
public class CodPostal {
    @Id
    @Column(name = "cod_postal", nullable = false, length = 10)
    private String codPostal;

    @Column(name = "localidade", nullable = false, length = 20)
    private String localidade;

    @OneToMany(mappedBy = "codPostal")
    private Set<Candidato> candidatoes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "codPostal")
    private Set<Cliente> clientes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "codPostal")
    private Set<Colaborador> colaboradors = new LinkedHashSet<>();

    @OneToMany(mappedBy = "codPostal")
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

    public Set<Candidato> getCandidatoes() {
        return candidatoes;
    }

    public void setCandidatoes(Set<Candidato> candidatoes) {
        this.candidatoes = candidatoes;
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