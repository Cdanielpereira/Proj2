package estg.ipvc.proj2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "avaliacao")
public class Avaliacao {
    @EmbeddedId
    private AvaliacaoId id;

    @MapsId("idFunc")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_func", nullable = false)
    private Funcionario idFunc;

    @MapsId("idCand")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cand", nullable = false)
    private Candidato idCand;

    @Column(name = "resultado")
    private Boolean resultado;

    public AvaliacaoId getId() {
        return id;
    }

    public void setId(AvaliacaoId id) {
        this.id = id;
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

    public Boolean getResultado() {
        return resultado;
    }

    public void setResultado(Boolean resultado) {
        this.resultado = resultado;
    }

}