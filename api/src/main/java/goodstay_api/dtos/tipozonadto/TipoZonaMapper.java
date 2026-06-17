package goodstay_api.dtos.tipozonadto;

import goodstay_api.model.TipoZona;

public class TipoZonaMapper {

    public static TipoZonaDto toDto(TipoZona entity) {
        if (entity == null) return null;

        TipoZonaDto dto = new TipoZonaDto();
        dto.setId(entity.getId());
        dto.setType(entity.getType());
        return dto;
    }

    public static TipoZona toEntity(TipoZonaDto dto) {
        if (dto == null) return null;

        TipoZona entity = new TipoZona();
        entity.setId(dto.getId());
        entity.setType(dto.getType());
        return entity;
    }
}