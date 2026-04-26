package estg.ipvc.proj2.dtos.UserDto;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

import estg.ipvc.proj2.dtos.ClienteDto.ClienteDto;
import estg.ipvc.proj2.dtos.FuncionarioDto.FuncionarioDto;

@Entity
@Table(name = "\"user\"")
public class UserDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Integer id;

    @Column(name = "username", nullable = false, length = 100)
    private String username;

    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @Column(name = "telefone", nullable = false, length = 15)
    private String telefone;


    public UserDto(String username, String password, String telefone) {
        this.username = username;
        this.password = password;
        this.telefone = telefone;
    }

     public UserDto() {

     }
    
    //Getters & Setters
    @OneToMany(mappedBy = "idUser")
    private Set<ClienteDto> clientes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idUser")
    private Set<FuncionarioDto> funcionarios = new LinkedHashSet<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id + '\n' +
                "telefone='" + telefone + '\n' +
                ", password='" + password + '\n' +
                ", username='" + username + '\n' +
                '}';
    }
}
