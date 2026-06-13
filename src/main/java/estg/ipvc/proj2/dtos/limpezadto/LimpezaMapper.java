package estg.ipvc.proj2.dtos.limpezadto;

import estg.ipvc.proj2.model.Limpeza;

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

        Limpeza l = new Limpeza();

        return l;
    }
}