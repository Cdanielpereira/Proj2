package goodstay_api.dtos.piscinadto;

import goodstay_api.model.Piscina;

public class PiscinaMapper {

    public static PiscinaDto toDto(Piscina entity) {
        if (entity == null) return null;

        PiscinaDto dto = new PiscinaDto();
        dto.setId(entity.getId());
        dto.setPh(entity.getPh());
        dto.setTemp(entity.getTemp());
        dto.setVolume(entity.getVolume());
        dto.setNivelCl(entity.getNivelCl());

        if (entity.getIdZona() != null) {
            dto.setIdZona(entity.getIdZona().getId());
        }

        return dto;
    }
}