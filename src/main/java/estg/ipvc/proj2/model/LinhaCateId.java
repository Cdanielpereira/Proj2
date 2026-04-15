package estg.ipvc.proj2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public class LinhaCateId implements Serializable {
    private static final long serialVersionUID = -6553397947738776747L;
    @Column(name = "id_servico", nullable = false)
    private Integer idServico;

    @Column(name = "id_cate", nullable = false)
    private Integer idCate;

    @Column(name = "precoatual", nullable = false, precision = 8, scale = 2)
    private BigDecimal precoatual;

    @Column(name = "ivaatual", nullable = false, precision = 7, scale = 2)
    private BigDecimal ivaatual;

    public Integer getIdServico() {
        return idServico;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    public Integer getIdCate() {
        return idCate;
    }

    public void setIdCate(Integer idCate) {
        this.idCate = idCate;
    }

    public BigDecimal getPrecoatual() {
        return precoatual;
    }

    public void setPrecoatual(BigDecimal precoatual) {
        this.precoatual = precoatual;
    }

    public BigDecimal getIvaatual() {
        return ivaatual;
    }

    public void setIvaatual(BigDecimal ivaatual) {
        this.ivaatual = ivaatual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinhaCateId entity = (LinhaCateId) o;
        return Objects.equals(this.idServico, entity.idServico) &&
                Objects.equals(this.idCate, entity.idCate) &&
                Objects.equals(this.precoatual, entity.precoatual) &&
                Objects.equals(this.ivaatual, entity.ivaatual);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idServico, idCate, precoatual, ivaatual);
    }
}