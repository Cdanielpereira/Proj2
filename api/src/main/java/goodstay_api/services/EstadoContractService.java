package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.estadocontractdto.EstadoContractDto;

public interface EstadoContractService {

    EstadoContractDto createEstadoContract(EstadoContractDto dto);

    PageResponse<EstadoContractDto> getAllEstadoContracts(int pageNo, int pageSize);

    EstadoContractDto getEstadoContractById(int id);

    EstadoContractDto updateEstadoContract(EstadoContractDto dto, int id);

    void deleteEstadoContract(int id);
}