package estg.ipvc.proj2.dtos.linhaencdto;

import estg.ipvc.proj2.model.LinhaEnc;
import estg.ipvc.proj2.model.LinhaEncId;

public class LinhaEncMapper {

    public static LinhaEncDto toDto(LinhaEnc entity) {
        if (entity == null) return null;

        LinhaEncDto dto = new LinhaEncDto();

        dto.setIdEnco(entity.getIdEnco().getId());
        dto.setIdProduto(entity.getIdProduto().getId());
        dto.setPrecoatual(entity.getPrecoatual());
        dto.setQtd(entity.getQtd());
        dto.setIvaatual(entity.getIvaatual());

        return dto;
    }

    public static LinhaEnc toEntity(LinhaEncDto dto) {
        if (dto == null) return null;

        LinhaEnc entity = new LinhaEnc();

        LinhaEncId id = new LinhaEncId();
        id.setIdEnco(dto.getIdEnco());
        id.setIdProduto(dto.getIdProduto());

        entity.setId(id);
        entity.setPrecoatual(dto.getPrecoatual());
        entity.setQtd(dto.getQtd());
        entity.setIvaatual(dto.getIvaatual());

        return entity;
    }
}