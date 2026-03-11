package estg.ipvc.proj2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estado_c")
public class EstadoC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estadoc", nullable = false)
    private Integer id;

    @Column(name = "estado", length = 30)
    private String estado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}