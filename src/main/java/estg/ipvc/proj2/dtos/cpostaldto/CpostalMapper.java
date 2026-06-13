package estg.ipvc.proj2.dtos.cpostaldto;

import estg.ipvc.proj2.model.Cpostal;

public class CpostalMapper {

    private CpostalMapper() {
        // utility class
    }

    /**
     * ENTITY -> DTO
     */
    public static CpostalDto toDto(Cpostal cpostal) {
        if (cpostal == null) {
            return null;
        }

        return CpostalDto.builder()
                .codPostal(cpostal.getCodPostal())
                .localidade(cpostal.getLocalidade())
                .build();
    }

    /**
     * DTO -> ENTITY
     */
    public static Cpostal toEntity(CpostalDto dto) {
        if (dto == null) {
            return null;
        }

        Cpostal cpostal = new Cpostal();
        cpostal.setCodPostal(dto.getCodPostal());
        cpostal.setLocalidade(dto.getLocalidade());

        return cpostal;
    }

    /**
     * UPDATE ENTITY
     */
    public static void updateEntityFromDto(CpostalDto dto, Cpostal cpostal) {
        if (dto == null || cpostal == null) {
            return;
        }

        cpostal.setLocalidade(dto.getLocalidade());
    }
}