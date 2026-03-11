package estg.ipvc.proj2.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tipo_aviso")
public class TipoAviso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipoaviso", nullable = false)
    private Integer id;

    @Column(name = "tipo", nullable = false, length = 30)
    private String tipo;

    @OneToMany(mappedBy = "idTipoaviso")
    private Set<Aviso> avisos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Set<Aviso> getAvisos() {
        return avisos;
    }

    public void setAvisos(Set<Aviso> avisos) {
        this.avisos = avisos;
    }

}