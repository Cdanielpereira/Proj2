package estg.ipvc.proj2.dtos.CateringDto;

import estg.ipvc.proj2.dtos.TipoIVADto.TipoIVADto;
import jakarta.persistence.*;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CateringDto {

    private Integer id;
    private Integer nhospedes;
    private BigDecimal precohosp;
    private TipoIVADto idiva;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) { this.id = id; }

    public Integer getNhospedes() { return nhospedes; }
    public void setNhospedes(Integer nhospedes) { this.nhospedes = nhospedes; }

    public BigDecimal getPrecohosp() { return precohosp; }
    public void setPrecohosp(BigDecimal precohosp) { this.precohosp = precohosp; }

    public TipoIVADto getIdiva() { return idiva; }
    public void setIdiva(TipoIVADto idiva) { this.idiva = idiva; }

}
