package goodstay_api.dtos.estadocontractdto;

import goodstay_api.model.EstadoContract;

public class EstadoContractMapper {

    private EstadoContractMapper() {}

    public static EstadoContractDto toDto(EstadoContract e) {
        if (e == null) return null;

        EstadoContractDto dto = new EstadoContractDto();

        dto.setId(e.getId());
        dto.setState(e.getState());

        return dto;
    }

    public static EstadoContract toEntity(EstadoContractDto dto) {
        if (dto == null) return null;

        EstadoContract e = new EstadoContract();

        e.setState(dto.getState());

        return e;
    }
}