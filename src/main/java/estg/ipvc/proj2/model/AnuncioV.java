package estg.ipvc.proj2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "anuncio_v")
public class AnuncioV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_anuv", nullable = false)
    private Integer id;

    @Column(name = "nvagas", nullable = false)
    private Integer nvagas;

    @Column(name = "descricao", length = Integer.MAX_VALUE)
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_contp", nullable = false)
    private ContratoPub idContp;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_aviso", nullable = false)
    private Aviso idAviso;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNvagas() {
        return nvagas;
    }

    public void setNvagas(Integer nvagas) {
        this.nvagas = nvagas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ContratoPub getIdContp() {
        return idContp;
    }

    public void setIdContp(ContratoPub idContp) {
        this.idContp = idContp;
    }

    public Aviso getIdAviso() {
        return idAviso;
    }

    public void setIdAviso(Aviso idAviso) {
        this.idAviso = idAviso;
    }

}