package goodstay_api.dtos.estadomarcacaodto;

import goodstay_api.model.EstadoMarcacao;

public class EstadoMarcacaoMapper {

    private EstadoMarcacaoMapper() {}

    public static EstadoMarcacaoDto toDto(EstadoMarcacao e) {
        if (e == null) return null;

        EstadoMarcacaoDto dto = new EstadoMarcacaoDto();

        dto.setId(e.getId());
        dto.setState(e.getState());

        return dto;
    }

    public static EstadoMarcacao toEntity(EstadoMarcacaoDto dto) {
        if (dto == null) return null;

        EstadoMarcacao e = new EstadoMarcacao();

        e.setState(dto.getState());

        return e;
    }
}