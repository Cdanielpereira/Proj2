package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "aviso")
public class Aviso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aviso", nullable = false)
    private Integer id;

    @Column(name = "descricao", length = Integer.MAX_VALUE)
    private String descricao;

    @Column(name = "dt_criacao")
    private LocalDate dtCriacao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipoaviso", nullable = false)
    private TipoAviso idTipoaviso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_note_env")
    private NoteEnv idNoteEnv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produto")
    private Produto idProduto;

    @OneToMany(mappedBy = "idAviso")
    private Set<AnuncioV> anuncioVS = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idAviso")
    private Set<Encomenda> encomendas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idAviso")
    private Set<Manutencao> manutencaos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(LocalDate dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public TipoAviso getIdTipoaviso() {
        return idTipoaviso;
    }

    public void setIdTipoaviso(TipoAviso idTipoaviso) {
        this.idTipoaviso = idTipoaviso;
    }

    public NoteEnv getIdNoteEnv() {
        return idNoteEnv;
    }

    public void setIdNoteEnv(NoteEnv idNoteEnv) {
        this.idNoteEnv = idNoteEnv;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    public Set<AnuncioV> getAnuncioVS() {
        return anuncioVS;
    }

    public void setAnuncioVS(Set<AnuncioV> anuncioVS) {
        this.anuncioVS = anuncioVS;
    }

    public Set<Encomenda> getEncomendas() {
        return encomendas;
    }

    public void setEncomendas(Set<Encomenda> encomendas) {
        this.encomendas = encomendas;
    }

    public Set<Manutencao> getManutencaos() {
        return manutencaos;
    }

    public void setManutencaos(Set<Manutencao> manutencaos) {
        this.manutencaos = manutencaos;
    }

}