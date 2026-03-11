package estg.ipvc.proj2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FormRoleId implements Serializable {
    private static final long serialVersionUID = -7394469472034387536L;
    @Column(name = "id_form", nullable = false)
    private Integer idForm;

    @Column(name = "id_contp", nullable = false)
    private Integer idContp;

    public Integer getIdForm() {
        return idForm;
    }

    public void setIdForm(Integer idForm) {
        this.idForm = idForm;
    }

    public Integer getIdContp() {
        return idContp;
    }

    public void setIdContp(Integer idContp) {
        this.idContp = idContp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FormRoleId entity = (FormRoleId) o;
        return Objects.equals(this.idForm, entity.idForm) &&
                Objects.equals(this.idContp, entity.idContp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idForm, idContp);
    }

}