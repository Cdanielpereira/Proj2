package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "candidato")
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cand", nullable = false)
    private Integer id;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "nif")
    private Integer nif;

    @Column(name = "telefone", length = 15)
    private String telefone;

    @Column(name = "email", length = 50)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_postal")
    private CodPostal codPostal;

    @OneToMany(mappedBy = "idCand")
    private Set<Avaliacao> avaliacaos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idCand")
    private Set<Entrevista> entrevistas = new LinkedHashSet<>();

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

    public CodPostal getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(CodPostal codPostal) {
        this.codPostal = codPostal;
    }

    public Set<Avaliacao> getAvaliacaos() {
        return avaliacaos;
    }

    public void setAvaliacaos(Set<Avaliacao> avaliacaos) {
        this.avaliacaos = avaliacaos;
    }

    public Set<Entrevista> getEntrevistas() {
        return entrevistas;
    }

    public void setEntrevistas(Set<Entrevista> entrevistas) {
        this.entrevistas = entrevistas;
    }

}