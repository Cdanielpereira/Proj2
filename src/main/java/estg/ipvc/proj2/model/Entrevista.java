package estg.ipvc.proj2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "entrevista")
public class Entrevista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrevista", nullable = false)
    private Integer id;

    @Column(name = "resultado")
    private Boolean resultado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_func")
    private Funcionario idFunc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cand")
    private Candidato idCand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento")
    private Evento idEvento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getResultado() {
        return resultado;
    }

    public void setResultado(Boolean resultado) {
        this.resultado = resultado;
    }

    public Funcionario getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(Funcionario idFunc) {
        this.idFunc = idFunc;
    }

    public Candidato getIdCand() {
        return idCand;
    }

    public void setIdCand(Candidato idCand) {
        this.idCand = idCand;
    }

    public Evento getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Evento idEvento) {
        this.idEvento = idEvento;
    }

}