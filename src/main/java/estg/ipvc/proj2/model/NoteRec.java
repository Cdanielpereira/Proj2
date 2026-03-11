package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "note_rec")
public class NoteRec {
    @EmbeddedId
    private NoteRecId id;

    @MapsId("idNoteEnv")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_note_env", nullable = false)
    private NoteEnv idNoteEnv;

    @MapsId("idFunc")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_func", nullable = false)
    private Funcionario idFunc;

    @Column(name = "dt_rec")
    private LocalDate dtRec;

    @Column(name = "mensagem", length = Integer.MAX_VALUE)
    private String mensagem;

    public NoteRecId getId() {
        return id;
    }

    public void setId(NoteRecId id) {
        this.id = id;
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

    public LocalDate getDtRec() {
        return dtRec;
    }

    public void setDtRec(LocalDate dtRec) {
        this.dtRec = dtRec;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}