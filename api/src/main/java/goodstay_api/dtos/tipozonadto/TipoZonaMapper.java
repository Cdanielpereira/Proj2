package goodstay_api.dtos.tipozonadto;

import goodstay_api.model.TipoZona;

public class TipoZonaMapper {

    public static TipoZonaDto toDto(TipoZona entity) {
        if (entity == null) return null;

        return TipoZonaDto.builder()
                .id(entity.getId())
                .type(entity.getType())
                .build();
    }

    public static TipoZona toEntity(TipoZonaDto dto) {
        if (dto == null) return null;

        TipoZona entity = new TipoZona();
        entity.setType(dto.getType());
        return entity;
    }
}