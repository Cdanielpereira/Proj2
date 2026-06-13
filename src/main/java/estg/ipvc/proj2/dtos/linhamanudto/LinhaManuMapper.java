package estg.ipvc.proj2.dtos.linhamanudto;

import estg.ipvc.proj2.model.LinhaManu;

public class LinhaManuMapper {

    public static LinhaManuDto toDto(LinhaManu entity) {
        if (entity == null) return null;

        LinhaManuDto dto = new LinhaManuDto();
        dto.setIdManu(entity.getIdManu().getId());
        dto.setIdServico(entity.getIdServico().getId());
        dto.setPrecoatual(entity.getPrecoatual());
        dto.setIvaatual(entity.getIvaatual());
        return dto;
    }
}