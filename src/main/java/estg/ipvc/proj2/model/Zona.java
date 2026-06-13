package estg.ipvc.proj2.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zona")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Zona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zona", nullable = false)
    private Integer id;
    @Column(name = "andar", length = 15)
    private String andar;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipoz", nullable = false)
    private TipoZona idTipoz;

    @OneToMany(mappedBy = "idZona")
    private Set<Limpeza> limpezas = new LinkedHashSet<>();
    @OneToMany(mappedBy = "idZona")
    private Set<Manutencao> manutencaos = new LinkedHashSet<>();
    @OneToMany(mappedBy = "idZona")
    private Set<Piscina> piscinas = new LinkedHashSet<>();

    @OneToOne(mappedBy = "idZona")
    private Quarto quarto;
}