package goodstay_api.dtos.manutencaodto;

import goodstay_api.model.Manutencao;

public class ManutencaoMapper {

    private ManutencaoMapper() {}

    /**
     * ENTITY -> DTO
     */
    public static ManutencaoDto toDto(Manutencao entity) {
        if (entity == null) return null;

        ManutencaoDto dto = new ManutencaoDto();

        dto.setId(entity.getId());
        dto.setDescricao(entity.getDescricao());

        dto.setIdZona(entity.getIdZona() != null ? entity.getIdZona().getId() : null);
        dto.setIdiva(entity.getIdiva() != null ? entity.getIdiva().getId() : null);

        return dto;
    }

    /**
     * DTO -> ENTITY
     */
    public static Manutencao toEntity(ManutencaoDto dto) {
        if (dto == null) return null;

        Manutencao entity = new Manutencao();

        entity.setId(dto.getId());
        entity.setDescricao(dto.getDescricao());

        return entity;
    }
}