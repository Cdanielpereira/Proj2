package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "anuncio_promo")
public class AnuncioPromo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_anup", nullable = false)
    private Integer id;

    @Column(name = "dt_ini")
    private LocalDate dtIni;

    @Column(name = "dt_fim")
    private LocalDate dtFim;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_contp", nullable = false)
    private ContratoPub idContp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public ContratoPub getIdContp() {
        return idContp;
    }

    public void setIdContp(ContratoPub idContp) {
        this.idContp = idContp;
    }

}