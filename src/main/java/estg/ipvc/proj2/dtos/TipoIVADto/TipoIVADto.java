package estg.ipvc.proj2.dtos.TipoIVADto;

import estg.ipvc.proj2.dtos.CateringDto.CateringDto;
import estg.ipvc.proj2.dtos.ManutencaoDto.ManutencaoDto;
import estg.ipvc.proj2.dtos.ProdutoDto.ProdutoDto;
import estg.ipvc.proj2.dtos.QuartoDto.QuartoDto;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tipo_iva")
public class TipoIVADto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idiva", nullable = false)
    private Integer id;

    @Column(name = "type", nullable = false, length = 20)
    private String type;

    @Column(name = "valor", nullable = false, precision = 5, scale = 2 )
    private BigDecimal valor;

    @OneToMany(mappedBy = "idiva")
    private Set<QuartoDto> quartos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idiva")
    private Set<ProdutoDto> produtos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idiva")
    private Set<ManutencaoDto> manutencoes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idiva")
    private Set<CateringDto> caterings = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public Set<QuartoDto> getQuartos() {
        return quartos;
    }
    public void setQuartos(Set<QuartoDto> quartos) {
        this.quartos = quartos;
    }

    public Set<ProdutoDto> getProdutos() {
        return produtos;
    }
    public void setProdutos(Set<ProdutoDto> produtos) {
        this.produtos = produtos;
    }

    public Set<ManutencaoDto> getManutencoes() {
        return manutencoes;
    }
    public void setManutencoes(Set<ManutencaoDto> manutencoes) {
        this.manutencoes = manutencoes;
    }

    public Set<CateringDto> getCaterings() {
        return caterings;
    }
    public void setCaterings(Set<CateringDto> caterings) {
        this.caterings = caterings;
    }

}
