package estg.ipvc.proj2.dtos.tipoIVAdto;

import estg.ipvc.proj2.model.TipoIVA;

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
        e.setType(dto.getType());
        e.setValor(dto.getValor());
        return e;
    }
}