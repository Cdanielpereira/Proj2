package goodstay_api.dtos.vencimentodto;

import goodstay_api.model.*;
import goodstay_api.model.Vencimento;

public class VencimentoMapper {

    public static VencimentoDto toDto(Vencimento e) {
        if (e == null) return null;

        return VencimentoDto.builder()
                .id(e.getId())
                .valor(e.getValor())
                .dtPag(e.getDtPag())
                .mes(e.getMes())
                .premio(e.getPremio())
                .iban(e.getIban())
                .idContrato(e.getIdContrato() != null ? e.getIdContrato().getId() : null)
                .idMetodo(e.getIdMetodo() != null ? e.getIdMetodo().getId() : null)
                .build();
    }

    public static Vencimento toEntity(VencimentoDto dto) {
        if (dto == null) return null;

        Vencimento e = new Vencimento();
        e.setValor(dto.getValor());
        e.setDtPag(dto.getDtPag());
        e.setMes(dto.getMes());
        e.setPremio(dto.getPremio());
        e.setIban(dto.getIban());
        return e;
    }
}