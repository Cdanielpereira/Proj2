package goodstay_api.dtos.tipoquartodto;

import goodstay_api.model.TipoQuarto;

public class TipoQuartoMapper {

    public static TipoQuartoDto toDto(TipoQuarto entity) {
        if (entity == null) return null;

        TipoQuartoDto dto = new TipoQuartoDto();
        dto.setId(entity.getId());
        dto.setType(entity.getType());
        return dto;
    }

    public static TipoQuarto toEntity(TipoQuartoDto dto) {
        if (dto == null) return null;

        TipoQuarto entity = new TipoQuarto();
        entity.setId(dto.getId());
        entity.setType(dto.getType());
        return entity;
    }
}