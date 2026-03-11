package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "nif", nullable = false)
    private Integer nif;

    @Column(name = "telefone", nullable = false, length = 15)
    private String telefone;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "rua", length = 25)
    private String rua;

    @Column(name = "nporta", length = 20)
    private String nporta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_postal")
    private CodPostal codPostal;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user", nullable = false)
    private Utilizador idUser;

    @OneToMany(mappedBy = "idCliente")
    private Set<Marcacao> marcacaos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNif() {
        return nif;
    }

    public void setNif(Integer nif) {
        this.nif = nif;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNporta() {
        return nporta;
    }

    public void setNporta(String nporta) {
        this.nporta = nporta;
    }

    public CodPostal getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(CodPostal codPostal) {
        this.codPostal = codPostal;
    }

    public Utilizador getIdUser() {
        return idUser;
    }

    public void setIdUser(Utilizador idUser) {
        this.idUser = idUser;
    }

    public Set<Marcacao> getMarcacaos() {
        return marcacaos;
    }

    public void setMarcacaos(Set<Marcacao> marcacaos) {
        this.marcacaos = marcacaos;
    }

}