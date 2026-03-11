package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "fatura_recibo")
public class FaturaRecibo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_faturar", nullable = false)
    private Integer id;

    @Column(name = "nif")
    private Integer nif;

    @Column(name = "valor", nullable = false, precision = 8, scale = 2)
    private BigDecimal valor;

    @Column(name = "dt_pag", nullable = false)
    private OffsetDateTime dtPag;

    @OneToMany(mappedBy = "idFaturar")
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public OffsetDateTime getDtPag() {
        return dtPag;
    }

    public void setDtPag(OffsetDateTime dtPag) {
        this.dtPag = dtPag;
    }

    public Set<Marcacao> getMarcacaos() {
        return marcacaos;
    }

    public void setMarcacaos(Set<Marcacao> marcacaos) {
        this.marcacaos = marcacaos;
    }

}