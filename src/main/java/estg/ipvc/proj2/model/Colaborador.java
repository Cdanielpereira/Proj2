package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "colaborador")
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_colab", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "nif", nullable = false)
    private Integer nif;

    @Column(name = "telefone", nullable = false, length = 15)
    private String telefone;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "iban", length = 25)
    private String iban;

    @Column(name = "rua", nullable = false, length = 25)
    private String rua;

    @Column(name = "nporta", nullable = false, length = 20)
    private String nporta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipocolab", nullable = false)
    private TipoColab idTipocolab;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cod_postal", nullable = false)
    private CodPostal codPostal;

    @OneToMany(mappedBy = "idColab")
    private Set<Catering> caterings = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idColab")
    private Set<Encomenda> encomendas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idColab")
    private Set<Manutencao> manutencaos = new LinkedHashSet<>();

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

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
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

    public TipoColab getIdTipocolab() {
        return idTipocolab;
    }

    public void setIdTipocolab(TipoColab idTipocolab) {
        this.idTipocolab = idTipocolab;
    }

    public CodPostal getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(CodPostal codPostal) {
        this.codPostal = codPostal;
    }

    public Set<Catering> getCaterings() {
        return caterings;
    }

    public void setCaterings(Set<Catering> caterings) {
        this.caterings = caterings;
    }

    public Set<Encomenda> getEncomendas() {
        return encomendas;
    }

    public void setEncomendas(Set<Encomenda> encomendas) {
        this.encomendas = encomendas;
    }

    public Set<Manutencao> getManutencaos() {
        return manutencaos;
    }

    public void setManutencaos(Set<Manutencao> manutencaos) {
        this.manutencaos = manutencaos;
    }

}