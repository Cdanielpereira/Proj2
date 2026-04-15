package estg.ipvc.proj2.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "funcionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_func", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user", nullable = false)
    private User idUser;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ColumnDefault("2")
    @JoinColumn(name = "id_tipofunc", nullable = false)
    private TipoFunc idTipoFunc;

    @Column(name = "iban", nullable = false, length = 30)
    private String iban;

    @Column(name = "nif", precision = 15)
    private BigDecimal nif;

    @Column(name = "rua", nullable = false, length = 50)
    private String rua;

    @Column(name = "porta", nullable = false, length = 20)
    private String porta;

    @Column(name = "dt_nasc", nullable = false)
    private LocalDate dtNasc;

    @Column(name = "sexo", nullable = false, length = 15)
    private String sexo;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "email", length = 50)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cpostal", nullable = false)
    private Cpostal cpostal;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_nacional", nullable = false)
    private Nacionalidade idNacional;

    @OneToMany(mappedBy = "idFunc")
    private Set<Contrato> contratos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idFunc")
    private Set<FaturaPagamento> faturaPagamentos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idFunc")
    private Set<Limpeza> limpezas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idFunc")
    private Set<Servico> servicos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public TipoFunc getIdTipofunc() {
        return idTipofunc;
    }

    public void setIdTipoFunc(TipoFunc idTipoFunc) {
        this.idTipoFunc = idTipoFunc;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public BigDecimal getNif() {
        return nif;
    }

    public void setNif(BigDecimal nif) {
        this.nif = nif;
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

    public LocalDate getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(LocalDate dtNasc) {
        this.dtNasc = dtNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Set<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(Set<Contrato> contratos) {
        this.contratos = contratos;
    }

    public Set<FaturaPagamento> getFaturaPagamentos() {
        return faturaPagamentos;
    }

    public void setFaturaPagamentos(Set<FaturaPagamento> faturaPagamentos) {
        this.faturaPagamentos = faturaPagamentos;
    }

    public Set<Limpeza> getLimpezas() {
        return limpezas;
    }

    public void setLimpezas(Set<Limpeza> limpezas) {
        this.limpezas = limpezas;
    }

    public Set<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(Set<Servico> servicos) {
        this.servicos = servicos;
    }

}