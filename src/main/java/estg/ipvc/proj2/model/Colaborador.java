package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "colaborador")
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_colab", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipocolab", nullable = false)
    private TipoColab idTipocolab;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "telefone", nullable = false, length = 15)
    private String telefone;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "rua", nullable = false, length = 50)
    private String rua;

    @Column(name = "nporta", nullable = false, length = 20)
    private String nporta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cpostal", nullable = false)
    private Cpostal cpostal;

    @Column(name = "iban", precision = 30)
    private BigDecimal iban;

    @OneToMany(mappedBy = "idColab")
    private Set<Servico> servicos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoColab getIdTipocolab() {
        return idTipocolab;
    }

    public void setIdTipocolab(TipoColab idTipocolab) {
        this.idTipocolab = idTipocolab;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Cpostal getCpostal() {
        return cpostal;
    }

    public void setCpostal(Cpostal cpostal) {
        this.cpostal = cpostal;
    }

    public BigDecimal getIban() {
        return iban;
    }

    public void setIban(BigDecimal iban) {
        this.iban = iban;
    }

    public Set<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(Set<Servico> servicos) {
        this.servicos = servicos;
    }

}