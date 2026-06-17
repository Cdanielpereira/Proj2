package goodstay_api.dtos.tipoIVAdto;

import goodstay_api.model.TipoIVA;

public class TipoIVAMapper {

    public static TipoIVADto toDto(TipoIVA e) {
        if (e == null) return null;

        return TipoIVADto.builder()
                .id(e.getId())
                .type(e.getType())
                .valor(e.getValor())
                .build();
    }

    public static TipoIVA toEntity(TipoIVADto dto) {
        if (dto == null) return null;

        TipoIVA e = new TipoIVA();
        e.setId(dto.getId());
        e.setType(dto.getType());
        e.setValor(dto.getValor());
        return e;
    }
}