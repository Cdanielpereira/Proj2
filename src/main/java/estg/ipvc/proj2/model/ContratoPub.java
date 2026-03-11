package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "contrato_pub")
public class ContratoPub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contp", nullable = false)
    private Integer id;

    @Column(name = "valor", precision = 6, scale = 2)
    private BigDecimal valor;

    @Column(name = "npub", nullable = false)
    private Integer npub;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_contrato", nullable = false)
    private Contrato idContrato;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_func", nullable = false)
    private Funcionario idFunc;

    @OneToMany(mappedBy = "idContp")
    private Set<AnuncioPromo> anuncioPromos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idContp")
    private Set<AnuncioV> anuncioVS = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idContp")
    private Set<FormRole> formRoles = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getNpub() {
        return npub;
    }

    public void setNpub(Integer npub) {
        this.npub = npub;
    }

    public Contrato getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Contrato idContrato) {
        this.idContrato = idContrato;
    }

    public Funcionario getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(Funcionario idFunc) {
        this.idFunc = idFunc;
    }

    public Set<AnuncioPromo> getAnuncioPromos() {
        return anuncioPromos;
    }

    public void setAnuncioPromos(Set<AnuncioPromo> anuncioPromos) {
        this.anuncioPromos = anuncioPromos;
    }

    public Set<AnuncioV> getAnuncioVS() {
        return anuncioVS;
    }

    public void setAnuncioVS(Set<AnuncioV> anuncioVS) {
        this.anuncioVS = anuncioVS;
    }

    public Set<FormRole> getFormRoles() {
        return formRoles;
    }

    public void setFormRoles(Set<FormRole> formRoles) {
        this.formRoles = formRoles;
    }

}