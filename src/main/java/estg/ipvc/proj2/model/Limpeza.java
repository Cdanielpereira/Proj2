package estg.ipvc.proj2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "limpeza")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Limpeza {
    @EmbeddedId
    private LimpezaId id;
    @Column(name = "dt_reali", nullable = false)
    private LocalDate dtReali;

    @MapsId("idZona")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_zona", nullable = false)
    private Zona idZona;
    @MapsId("idFunc")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_func", nullable = false)
    private Funcionario idFunc;


}