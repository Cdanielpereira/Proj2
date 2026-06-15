package goodstay_api.dtos.tipoquartodto;

import goodstay_api.model.TipoQuarto;

public class TipoQuartoMapper {

    public static TipoQuartoDto toDto(TipoQuarto entity) {
        if (entity == null) return null;

        return TipoQuartoDto.builder()
                .id(entity.getId())
                .type(entity.getType())
                .build();
    }

    public static TipoQuarto toEntity(TipoQuartoDto dto) {
        if (dto == null) return null;

        TipoQuarto entity = new TipoQuarto();
        entity.setType(dto.getType());
        return entity;
    }
}