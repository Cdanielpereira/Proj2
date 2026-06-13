package estg.ipvc.proj2.dtos.manutencaodto;

import estg.ipvc.proj2.model.Manutencao;

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
}