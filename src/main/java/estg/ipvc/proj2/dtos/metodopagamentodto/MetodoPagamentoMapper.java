package estg.ipvc.proj2.dtos.metodopagamentodto;

import estg.ipvc.proj2.model.MetodoPagamento;

public class MetodoPagamentoMapper {

    public static MetodoPagamentoDto toDto(MetodoPagamento entity) {
        if (entity == null) return null;

        MetodoPagamentoDto dto = new MetodoPagamentoDto();
        dto.setId(entity.getId());
        dto.setMetodo(entity.getMetodo());
        return dto;
    }
}