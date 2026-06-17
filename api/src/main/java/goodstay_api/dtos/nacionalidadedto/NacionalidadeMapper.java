package goodstay_api.dtos.nacionalidadedto;

import goodstay_api.model.Nacionalidade;

public final class NacionalidadeMapper {

    private NacionalidadeMapper() {}

    public static NacionalidadeDto toDto(Nacionalidade e) {
        if (e == null) return null;

        NacionalidadeDto dto = new NacionalidadeDto();
        dto.setId(e.getId());
        dto.setNacionalidade(e.getNacionalidade());
        return dto;
    }

    public static Nacionalidade toEntity(NacionalidadeDto dto) {
        if (dto == null) return null;

        Nacionalidade e = new Nacionalidade();
        e.setId(dto.getId());
        e.setNacionalidade(dto.getNacionalidade());
        return e;
    }

    public static void updateEntityFromDto(NacionalidadeDto dto, Nacionalidade e) {
        if (dto == null || e == null) return;

        if (dto.getNacionalidade() != null) {
            e.setNacionalidade(dto.getNacionalidade());
        }
    }
}