package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "fatura_pag")
public class FaturaPag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_faturap", nullable = false)
    private Integer id;

    @Column(name = "iban", length = 25)
    private String iban;

    @Column(name = "valor", nullable = false, precision = 8, scale = 2)
    private BigDecimal valor;

    @Column(name = "dt_pag")
    private OffsetDateTime dtPag;

    @OneToMany(mappedBy = "idFaturap")
    private Set<Evento> eventos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
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

    public Set<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(Set<Evento> eventos) {
        this.eventos = eventos;
    }

}