package goodstay_api.dtos.limpezadto;

import goodstay_api.model.Limpeza;
import goodstay_api.model.LimpezaId;

public class LimpezaMapper {

    private LimpezaMapper() {}

    public static LimpezaDto toDto(Limpeza l) {
        if (l == null) return null;

        LimpezaDto dto = new LimpezaDto();

        dto.setDtReali(l.getDtReali());

        if (l.getId() != null) {
            dto.setIdZona(l.getId().getIdZona());
            dto.setIdFunc(l.getId().getIdFunc());
        }

        return dto;
    }

    public static Limpeza toEntity(LimpezaDto dto) {
        if (dto == null) return null;

        Limpeza limpeza = new Limpeza();

        LimpezaId id = new LimpezaId();
        id.setIdZona(dto.getIdZona());
        id.setIdFunc(dto.getIdFunc());

        limpeza.setId(id);
        limpeza.setDtReali(dto.getDtReali());

        return limpeza;
    }
}