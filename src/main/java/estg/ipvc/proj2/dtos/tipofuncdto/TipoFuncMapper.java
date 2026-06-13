package estg.ipvc.proj2.dtos.tipofuncdto;

import estg.ipvc.proj2.model.TipoFunc;

public class TipoFuncMapper {

    public static TipoFuncDto toDto(TipoFunc entity) {
        if (entity == null) return null;

        return TipoFuncDto.builder()
                .id(entity.getId())
                .type(entity.getType())
                .build();
    }

    public static TipoFunc toEntity(TipoFuncDto dto) {
        if (dto == null) return null;

        TipoFunc entity = new TipoFunc();
        entity.setType(dto.getType());
        return entity;
    }
}