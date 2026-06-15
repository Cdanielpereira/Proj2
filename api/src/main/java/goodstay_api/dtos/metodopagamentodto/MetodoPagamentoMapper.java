package goodstay_api.dtos.metodopagamentodto;

import goodstay_api.model.MetodoPagamento;

public class MetodoPagamentoMapper {

    public static MetodoPagamentoDto toDto(MetodoPagamento entity) {
        if (entity == null) return null;

        MetodoPagamentoDto dto = new MetodoPagamentoDto();
        dto.setId(entity.getId());
        dto.setMetodo(entity.getMetodo());
        return dto;
    }

    public static MetodoPagamento toEntity(MetodoPagamentoDto dto) {
        if (dto == null) return null;

        MetodoPagamento entity = new MetodoPagamento();
        entity.setMetodo(dto.getMetodo());

        return entity;
    }
}