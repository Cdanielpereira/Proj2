package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "carta")
public class Carta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carta", nullable = false)
    private Integer id;

    @Column(name = "descricao", length = Integer.MAX_VALUE)
    private String descricao;

    @Column(name = "dt_fim")
    private LocalDate dtFim;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_note_env")
    private NoteEnv idNoteEnv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_func")
    private Funcionario idFunc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipocarta")
    private TipoCarta idTipocarta;

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

    public LocalDate getDtFim() {
        return dtFim;
    }

    public void setDtFim(LocalDate dtFim) {
        this.dtFim = dtFim;
    }

    public NoteEnv getIdNoteEnv() {
        return idNoteEnv;
    }

    public void setIdNoteEnv(NoteEnv idNoteEnv) {
        this.idNoteEnv = idNoteEnv;
    }

    public Funcionario getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(Funcionario idFunc) {
        this.idFunc = idFunc;
    }

    public TipoCarta getIdTipocarta() {
        return idTipocarta;
    }

    public void setIdTipocarta(TipoCarta idTipocarta) {
        this.idTipocarta = idTipocarta;
    }

}