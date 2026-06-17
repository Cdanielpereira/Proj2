package goodstay_api.dtos.piscinadto;

import goodstay_api.model.Piscina;
import goodstay_api.model.Zona;

public final class PiscinaMapper {

    private PiscinaMapper() {}

    public static PiscinaDto toDto(Piscina e) {
        if (e == null) return null;

        PiscinaDto dto = new PiscinaDto();
        dto.setId(e.getId());
        dto.setPh(e.getPh());
        dto.setTemp(e.getTemp());
        dto.setVolume(e.getVolume());
        dto.setNivelCl(e.getNivelCl());

        if (e.getIdZona() != null) {
            dto.setIdZona(e.getIdZona().getId());
        }

        return dto;
    }

    public static Piscina toEntity(PiscinaDto dto) {
        if (dto == null) return null;

        Piscina e = new Piscina();
        e.setId(dto.getId());
        e.setPh(dto.getPh());
        e.setTemp(dto.getTemp());
        e.setVolume(dto.getVolume());
        e.setNivelCl(dto.getNivelCl());

        if (dto.getIdZona() != null) {
            Zona z = new Zona();
            z.setId(dto.getIdZona());
            e.setIdZona(z);
        }

        return e;
    }

    public static void updateEntityFromDto(PiscinaDto dto, Piscina e) {
        if (dto == null || e == null) return;

        if (dto.getPh() != null) e.setPh(dto.getPh());
        if (dto.getTemp() != null) e.setTemp(dto.getTemp());
        if (dto.getVolume() != null) e.setVolume(dto.getVolume());
        if (dto.getNivelCl() != null) e.setNivelCl(dto.getNivelCl());

        if (dto.getIdZona() != null) {
            Zona z = new Zona();
            z.setId(dto.getIdZona());
            e.setIdZona(z);
        }
    }
}