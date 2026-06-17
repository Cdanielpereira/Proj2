package goodstay_api.dtos.metodopagamentodto;

import goodstay_api.model.MetodoPagamento;

public final class MetodoPagamentoMapper {

    private MetodoPagamentoMapper() {}

    public static MetodoPagamentoDto toDto(MetodoPagamento e) {
        if (e == null) return null;

        MetodoPagamentoDto dto = new MetodoPagamentoDto();
        dto.setId(e.getId());
        dto.setMetodo(e.getMetodo());
        return dto;
    }

    public static MetodoPagamento toEntity(MetodoPagamentoDto dto) {
        if (dto == null) return null;

        MetodoPagamento e = new MetodoPagamento();
        e.setId(dto.getId());
        e.setMetodo(dto.getMetodo());
        return e;
    }
}