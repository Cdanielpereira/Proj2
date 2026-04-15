package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", nullable = false)
    private Integer id;
    @Column(name = "nif")
    private Integer nif;
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    @Column(name = "dt_nasc")
    private LocalDate dtNasc;
    @Column(name = "rua", length = 50)
    private String rua;
    @Column(name = "porta", length = 20)
    private String porta;
    @Column(name = "sexo", length = 15)
    private String sexo;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user", nullable = false)
    private User idUser;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpostal")
    private Cpostal cpostal;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nacional")
    private Nacionalidade idNacional;
    @Column(name = "email", length = 50)
    private String email;


    @OneToMany(mappedBy = "idCliente")
    private Set<Marcacao> marcacaos = new LinkedHashSet<>();


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNif() {
        return nif;
    }
    public void setNif(Integer nif) {
        this.nif = nif;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDtNasc() {
        return dtNasc;
    }
    public void setDtNasc(LocalDate dtNasc) {
        this.dtNasc = dtNasc;
    }

    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getPorta() {
        return porta;
    }
    public void setPorta(String porta) {
        this.porta = porta;
    }

    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public User getIdUser() {
        return idUser;
    }
    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Cpostal getCpostal() {
        return cpostal;
    }
    public void setCpostal(Cpostal cpostal) {
        this.cpostal = cpostal;
    }

    public Nacionalidade getIdNacional() {
        return idNacional;
    }
    public void setIdNacional(Nacionalidade idNacional) {
        this.idNacional = idNacional;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Marcacao> getMarcacaos() {
        return marcacaos;
    }
    public void setMarcacaos(Set<Marcacao> marcacaos) {
        this.marcacaos = marcacaos;
    }

}