package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "linha_enc")
public class LinhaEnc {
    @EmbeddedId
    private LinhaEncId id;

    @MapsId("idEncomenda")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_encomenda", nullable = false)
    private Encomenda idEncomenda;

    @MapsId("idProduto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto idProduto;

    @Column(name = "qtd", nullable = false, precision = 5, scale = 2)
    private BigDecimal qtd;

    @Column(name = "precoatual", nullable = false, precision = 5, scale = 2)
    private BigDecimal precoatual;

    public LinhaEncId getId() {
        return id;
    }

    public void setId(LinhaEncId id) {
        this.id = id;
    }

    public Encomenda getIdEncomenda() {
        return idEncomenda;
    }

    public void setIdEncomenda(Encomenda idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    public BigDecimal getQtd() {
        return qtd;
    }

    public void setQtd(BigDecimal qtd) {
        this.qtd = qtd;
    }

    public BigDecimal getPrecoatual() {
        return precoatual;
    }

    public void setPrecoatual(BigDecimal precoatual) {
        this.precoatual = precoatual;
    }

}