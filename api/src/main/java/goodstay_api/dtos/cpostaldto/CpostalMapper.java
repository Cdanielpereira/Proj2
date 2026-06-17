package goodstay_api.dtos.cpostaldto;

import goodstay_api.model.Cpostal;

public class CpostalMapper {

    private CpostalMapper() {}

    public static CpostalDto toDto(Cpostal cpostal) {
        if (cpostal == null) return null;

        return CpostalDto.builder()
                .codPostal(cpostal.getCodPostal())
                .localidade(cpostal.getLocalidade())
                .build();
    }

    public static Cpostal toEntity(CpostalDto dto) {
        if (dto == null) return null;

        Cpostal c = new Cpostal();
        c.setCodPostal(dto.getCodPostal());
        c.setLocalidade(dto.getLocalidade());

        return c;
    }

    public static void updateEntityFromDto(CpostalDto dto, Cpostal c) {
        if (dto == null || c == null) return;

        c.setLocalidade(dto.getLocalidade());
    }
}