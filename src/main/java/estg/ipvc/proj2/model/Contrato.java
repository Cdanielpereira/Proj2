package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "contrato")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contrato", nullable = false)
    private Integer id;

    @Column(name = "dt_criacao", nullable = false)
    private LocalDate dtCriacao;

    @Column(name = "dt_ini", nullable = false)
    private LocalDate dtIni;

    @Column(name = "dt_fim", nullable = false)
    private LocalDate dtFim;

    @Column(name = "dt_assinatura")
    private LocalDate dtAssinatura;

    @OneToMany(mappedBy = "idContrato")
    private Set<ContratoFunc> contratoFuncs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idContrato")
    private Set<ContratoPub> contratoPubs = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(LocalDate dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public LocalDate getDtIni() {
        return dtIni;
    }

    public void setDtIni(LocalDate dtIni) {
        this.dtIni = dtIni;
    }

    public LocalDate getDtFim() {
        return dtFim;
    }

    public void setDtFim(LocalDate dtFim) {
        this.dtFim = dtFim;
    }

    public LocalDate getDtAssinatura() {
        return dtAssinatura;
    }

    public void setDtAssinatura(LocalDate dtAssinatura) {
        this.dtAssinatura = dtAssinatura;
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

}