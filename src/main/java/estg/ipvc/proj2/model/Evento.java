package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento", nullable = false)
    private Integer id;

    @Column(name = "dt_marca", nullable = false)
    private LocalDate dtMarca;

    @Column(name = "nome", length = 50)
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_note_env")
    private NoteEnv idNoteEnv;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado idEstado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_faturap")
    private FaturaPag idFaturap;

    @OneToMany(mappedBy = "idEvento")
    private Set<Catering> caterings = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idEvento")
    private Set<Encomenda> encomendas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idEvento")
    private Set<Entrevista> entrevistas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idEvento")
    private Set<Manutencao> manutencaos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDtMarca() {
        return dtMarca;
    }

    public void setDtMarca(LocalDate dtMarca) {
        this.dtMarca = dtMarca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NoteEnv getIdNoteEnv() {
        return idNoteEnv;
    }

    public void setIdNoteEnv(NoteEnv idNoteEnv) {
        this.idNoteEnv = idNoteEnv;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    public FaturaPag getIdFaturap() {
        return idFaturap;
    }

    public void setIdFaturap(FaturaPag idFaturap) {
        this.idFaturap = idFaturap;
    }

    public Set<Catering> getCaterings() {
        return caterings;
    }

    public void setCaterings(Set<Catering> caterings) {
        this.caterings = caterings;
    }

    public Set<Encomenda> getEncomendas() {
        return encomendas;
    }

    public void setEncomendas(Set<Encomenda> encomendas) {
        this.encomendas = encomendas;
    }

    public Set<Entrevista> getEntrevistas() {
        return entrevistas;
    }

    public void setEntrevistas(Set<Entrevista> entrevistas) {
        this.entrevistas = entrevistas;
    }

    public Set<Manutencao> getManutencaos() {
        return manutencaos;
    }

    public void setManutencaos(Set<Manutencao> manutencaos) {
        this.manutencaos = manutencaos;
    }

}