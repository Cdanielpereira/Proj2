package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "linha_enc")
public class LinhaEnc {
    @EmbeddedId
    private LinhaEncId id;
    @MapsId("idEnco")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_enco", nullable = false)
    private Encomenda idEnco;
    @MapsId("idProduto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto idProduto;
    @Column(name = "precoatual", nullable = false, precision = 5, scale = 2)
    private BigDecimal precoAtual;
    @Column(name = "qtd", nullable = false)
    private Integer qtd;
    @Column(name = "ivaatual", nullable = false, precision = 3, scale = 2)
    private BigDecimal ivaAtual = idProduto.getTipoIVA().getValor();


    public LinhaEncId getId() {
        return id;
    }
    public void setId(LinhaEncId id) {
        this.id = id;
    }

    public Encomenda getIdEnco() {
        return idEnco;
    }
    public void setIdEnco(Encomenda idEnco) {
        this.idEnco = idEnco;
    }

    public Produto getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    public BigDecimal getPrecoAtual() {
        return precoAtual;
    }
    public void setPrecoAtual(BigDecimal precoAtual) {
        this.precoAtual = precoAtual;
    }

    public Integer getQtd() {
        return qtd;
    }
    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }



}