package goodstay_api.dtos.manutencaodto;

import goodstay_api.model.*;

public class ManutencaoMapper {

    public static ManutencaoDto toDto(Manutencao entity) {
        if (entity == null) return null;

        ManutencaoDto dto = new ManutencaoDto();

        dto.setId(entity.getId());
        dto.setDescricao(entity.getDescricao());
        dto.setIdZona(entity.getIdZona() != null ? entity.getIdZona().getId() : null);
        dto.setIdiva(entity.getIdiva() != null ? entity.getIdiva().getId() : null);

        return dto;
    }

    public static Manutencao toEntity(ManutencaoDto dto) {
        if (dto == null) return null;

        Manutencao entity = new Manutencao();

        entity.setId(dto.getId());
        entity.setDescricao(dto.getDescricao());

        if (dto.getIdZona() != null) {
            Zona z = new Zona();
            z.setId(dto.getIdZona());
            entity.setIdZona(z);
        }

        if (dto.getIdiva() != null) {
            TipoIVA iva = new TipoIVA();
            iva.setId(dto.getIdiva());
            entity.setIdiva(iva);
        }

        return entity;
    }
}