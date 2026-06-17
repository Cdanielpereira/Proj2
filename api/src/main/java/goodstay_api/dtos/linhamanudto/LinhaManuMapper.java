package goodstay_api.dtos.linhamanudto;

import goodstay_api.model.*;

public class LinhaManuMapper {

    public static LinhaManuDto toDto(LinhaManu entity) {
        if (entity == null) return null;

        LinhaManuDto dto = new LinhaManuDto();

        dto.setIdManu(entity.getIdManu() != null ? entity.getIdManu().getId() : null);
        dto.setIdServico(entity.getIdServico() != null ? entity.getIdServico().getId() : null);
        dto.setPrecoatual(entity.getPrecoatual());
        dto.setIvaatual(entity.getIvaatual());

        return dto;
    }

    public static LinhaManu toEntity(LinhaManuDto dto) {
        if (dto == null) return null;

        LinhaManu entity = new LinhaManu();

        LinhaManuId id = new LinhaManuId();
        id.setIdManu(dto.getIdManu());
        id.setIdServico(dto.getIdServico());

        entity.setId(id);
        entity.setPrecoatual(dto.getPrecoatual());
        entity.setIvaatual(dto.getIvaatual());

        return entity;
    }
}