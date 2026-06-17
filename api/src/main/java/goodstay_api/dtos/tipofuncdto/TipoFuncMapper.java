package goodstay_api.dtos.tipofuncdto;

import goodstay_api.model.TipoFunc;

public class TipoFuncMapper {

    public static TipoFuncDto toDto(TipoFunc e) {
        if (e == null) return null;

        return TipoFuncDto.builder()
                .id(e.getId())
                .type(e.getType())
                .build();
    }

    public static TipoFunc toEntity(TipoFuncDto dto) {
        if (dto == null) return null;

        TipoFunc e = new TipoFunc();
        e.setId(dto.getId());
        e.setType(dto.getType());
        return e;
    }
}