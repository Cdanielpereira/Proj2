package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tipo_func")
public class TipoFunc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipofunc", nullable = false)
    private Integer id;
    @Column(name = "type", nullable = false, length = 20)
    private String type;


    @OneToMany(mappedBy = "idTipoFunc")
    private Set<Funcionario> funcionarios = new LinkedHashSet<>();


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

    public Set<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    public void setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

}