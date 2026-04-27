package estg.ipvc.proj2.dtos.ColaboradorDto;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;
@Entity

@Table(name = "colaborador")
public class ColaboradorDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_colab", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipocolab", nullable = false)
    private TipoColabDto idTipocolab;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "telefone", nullable = false, length = 15)
    private String telefone;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "rua", nullable = false, length = 50)
    private String rua;

    @Column(name = "porta", nullable = false, length = 20)
    private String porta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cpostal", nullable = false)
    private CpostalDto cpostal;

    @Column(name = "iban", length = 30)
    private String iban;

    @OneToMany(mappedBy = "idColab")
    private Set<ServicoDto> servicos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoColabDto getIdTipocolab() {
        return idTipocolab;
    }

    public void setIdTipocolab(TipoColabDto idTipocolab) {
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
        return porta;
    }

    public void setNporta(String nporta) {
        this.porta = nporta;
    }

    public CpostalDto getCpostal() {
        return cpostal;
    }

    public void setCpostal(CpostalDto cpostal) {
        this.cpostal = cpostal;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Set<ServicoDto> getServicos() {
        return servicos;
    }

    public void setServicos(Set<ServicoDto> servicos) {
        this.servicos = servicos;
    }

}
