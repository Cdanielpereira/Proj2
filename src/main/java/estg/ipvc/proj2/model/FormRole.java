package estg.ipvc.proj2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "form_role")
public class FormRole {
    @EmbeddedId
    private FormRoleId id;

    @MapsId("idForm")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_form", nullable = false)
    private FormCont idForm;

    @MapsId("idContp")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_contp", nullable = false)
    private ContratoPub idContp;

    @Column(name = "resultado")
    private Boolean resultado;

    public FormRoleId getId() {
        return id;
    }

    public void setId(FormRoleId id) {
        this.id = id;
    }

    public FormCont getIdForm() {
        return idForm;
    }

    public void setIdForm(FormCont idForm) {
        this.idForm = idForm;
    }

    public ContratoPub getIdContp() {
        return idContp;
    }

    public void setIdContp(ContratoPub idContp) {
        this.idContp = idContp;
    }

    public Boolean getResultado() {
        return resultado;
    }

    public void setResultado(Boolean resultado) {
        this.resultado = resultado;
    }

}