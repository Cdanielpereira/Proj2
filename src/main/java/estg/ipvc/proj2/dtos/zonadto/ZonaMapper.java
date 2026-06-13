package estg.ipvc.proj2.dtos.zonadto;

import estg.ipvc.proj2.model.TipoZona;
import estg.ipvc.proj2.model.Zona;

public class ZonaMapper {

    public static ZonaDto toDto(Zona entity) {
        if (entity == null) return null;

        return ZonaDto.builder()
                .id(entity.getId())
                .idTipoz(entity.getIdTipoz() != null ? entity.getIdTipoz().getId() : null)
                .andar(entity.getAndar())
                .build();
    }

    public static Zona toEntity(ZonaDto dto) {
        if (dto == null) return null;

        Zona entity = new Zona();
        entity.setAndar(dto.getAndar());

        if (dto.getIdTipoz() != null) {
            TipoZona tz = new TipoZona();
            tz.setId(dto.getIdTipoz());
            entity.setIdTipoz(tz);
        }

        return entity;
    }
}