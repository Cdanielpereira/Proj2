package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "form_cont")
public class FormCont {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_form", nullable = false)
    private Integer id;

    @Column(name = "form", length = 30)
    private String form;

    @OneToMany(mappedBy = "idForm")
    private Set<FormRole> formRoles = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Set<FormRole> getFormRoles() {
        return formRoles;
    }

    public void setFormRoles(Set<FormRole> formRoles) {
        this.formRoles = formRoles;
    }

}