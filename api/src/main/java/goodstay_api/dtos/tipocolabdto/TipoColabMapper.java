package goodstay_api.dtos.tipocolabdto;

import goodstay_api.model.TipoColab;

public class TipoColabMapper {

    public static TipoColabDto toDto(TipoColab e) {
        if (e == null) return null;

        return TipoColabDto.builder()
                .id(e.getId())
                .type(e.getType())
                .build();
    }

    public static TipoColab toEntity(TipoColabDto dto) {
        if (dto == null) return null;

        TipoColab e = new TipoColab();
        e.setId(dto.getId());
        e.setType(dto.getType());
        return e;
    }
}