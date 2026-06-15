package goodstay_api.dtos.estadoservicodto;

import goodstay_api.model.EstadoServico;

public class EstadoServicoMapper {

    public static EstadoServicoDto toDto(EstadoServico e) {
        if (e == null) return null;

        return EstadoServicoDto.builder()
                .id(e.getId())
                .state(e.getState())
                .build();
    }

    public static EstadoServico toEntity(EstadoServicoDto dto) {
        if (dto == null) return null;

        EstadoServico e = new EstadoServico();
        e.setState(dto.getState());
        return e;
    }
}