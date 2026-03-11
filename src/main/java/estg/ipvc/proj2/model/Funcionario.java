package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "funcionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_func", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "nif", nullable = false)
    private Integer nif;

    @Column(name = "telefone", nullable = false, length = 15)
    private String telefone;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "iban", length = 25)
    private String iban;

    @Column(name = "rua", nullable = false, length = 25)
    private String rua;

    @Column(name = "nporta", nullable = false, length = 20)
    private String nporta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipofunc", nullable = false)
    private TipoFunc idTipofunc;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cod_postal", nullable = false)
    private CodPostal codPostal;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user", nullable = false)
    private Utilizador idUser;

    @OneToMany(mappedBy = "idFunc")
    private Set<Avaliacao> avaliacaos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idFunc")
    private Set<Carta> cartas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idFunc")
    private Set<Catering> caterings = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idFunc")
    private Set<ContratoFunc> contratoFuncs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idFunc")
    private Set<ContratoPub> contratoPubs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idFunc")
    private Set<Encomenda> encomendas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idFunc")
    private Set<Entrevista> entrevistas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idFunc")
    private Set<Limpeza> limpezas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idFunc")
    private Set<Manutencao> manutencaos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idFunc")
    private Set<NoteEnv> noteEnvs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idFunc")
    private Set<NoteRec> noteRecs = new LinkedHashSet<>();

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

    public TipoFunc getIdTipofunc() {
        return idTipofunc;
    }

    public void setIdTipofunc(TipoFunc idTipofunc) {
        this.idTipofunc = idTipofunc;
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

    public Set<Avaliacao> getAvaliacaos() {
        return avaliacaos;
    }

    public void setAvaliacaos(Set<Avaliacao> avaliacaos) {
        this.avaliacaos = avaliacaos;
    }

    public Set<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(Set<Carta> cartas) {
        this.cartas = cartas;
    }

    public Set<Catering> getCaterings() {
        return caterings;
    }

    public void setCaterings(Set<Catering> caterings) {
        this.caterings = caterings;
    }

    public Set<ContratoFunc> getContratoFuncs() {
        return contratoFuncs;
    }

    public void setContratoFuncs(Set<ContratoFunc> contratoFuncs) {
        this.contratoFuncs = contratoFuncs;
    }

    public Set<ContratoPub> getContratoPubs() {
        return contratoPubs;
    }

    public void setContratoPubs(Set<ContratoPub> contratoPubs) {
        this.contratoPubs = contratoPubs;
    }

    public Set<Encomenda> getEncomendas() {
        return encomendas;
    }

    public void setEncomendas(Set<Encomenda> encomendas) {
        this.encomendas = encomendas;
    }

    public Set<Entrevista> getEntrevistas() {
        return entrevistas;
    }

    public void setEntrevistas(Set<Entrevista> entrevistas) {
        this.entrevistas = entrevistas;
    }

    public Set<Limpeza> getLimpezas() {
        return limpezas;
    }

    public void setLimpezas(Set<Limpeza> limpezas) {
        this.limpezas = limpezas;
    }

    public Set<Manutencao> getManutencaos() {
        return manutencaos;
    }

    public void setManutencaos(Set<Manutencao> manutencaos) {
        this.manutencaos = manutencaos;
    }

    public Set<NoteEnv> getNoteEnvs() {
        return noteEnvs;
    }

    public void setNoteEnvs(Set<NoteEnv> noteEnvs) {
        this.noteEnvs = noteEnvs;
    }

    public Set<NoteRec> getNoteRecs() {
        return noteRecs;
    }

    public void setNoteRecs(Set<NoteRec> noteRecs) {
        this.noteRecs = noteRecs;
    }

}