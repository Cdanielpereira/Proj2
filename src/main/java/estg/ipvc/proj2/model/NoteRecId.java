package estg.ipvc.proj2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class NoteRecId implements Serializable {
    private static final long serialVersionUID = -8992171913482164878L;
    @Column(name = "id_note_env", nullable = false)
    private Integer idNoteEnv;

    @Column(name = "id_func", nullable = false)
    private Integer idFunc;

    public Integer getIdNoteEnv() {
        return idNoteEnv;
    }

    public void setIdNoteEnv(Integer idNoteEnv) {
        this.idNoteEnv = idNoteEnv;
    }

    public Integer getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(Integer idFunc) {
        this.idFunc = idFunc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        NoteRecId entity = (NoteRecId) o;
        return Objects.equals(this.idFunc, entity.idFunc) &&
                Objects.equals(this.idNoteEnv, entity.idNoteEnv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFunc, idNoteEnv);
    }

}