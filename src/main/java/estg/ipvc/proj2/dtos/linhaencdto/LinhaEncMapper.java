package estg.ipvc.proj2.dtos.linhaencdto;

import estg.ipvc.proj2.model.LinhaEnc;

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
}