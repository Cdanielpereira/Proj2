package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "note_env")
public class NoteEnv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_note_env", nullable = false)
    private Integer id;

    @Column(name = "dt_env")
    private LocalDate dtEnv;

    @Column(name = "mensagem", length = Integer.MAX_VALUE)
    private String mensagem;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_func", nullable = false)
    private Funcionario idFunc;

    @OneToMany(mappedBy = "idNoteEnv")
    private Set<Aviso> avisos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idNoteEnv")
    private Set<Carta> cartas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idNoteEnv")
    private Set<Evento> eventos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idNoteEnv")
    private Set<NoteRec> noteRecs = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDtEnv() {
        return dtEnv;
    }

    public void setDtEnv(LocalDate dtEnv) {
        this.dtEnv = dtEnv;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Funcionario getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(Funcionario idFunc) {
        this.idFunc = idFunc;
    }

    public Set<Aviso> getAvisos() {
        return avisos;
    }

    public void setAvisos(Set<Aviso> avisos) {
        this.avisos = avisos;
    }

    public Set<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(Set<Carta> cartas) {
        this.cartas = cartas;
    }

    public Set<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(Set<Evento> eventos) {
        this.eventos = eventos;
    }

    public Set<NoteRec> getNoteRecs() {
        return noteRecs;
    }

    public void setNoteRecs(Set<NoteRec> noteRecs) {
        this.noteRecs = noteRecs;
    }

}