package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.estadocontractdto.EstadoContractDto;

public interface EstadoContractService {

    EstadoContractDto createEstadoContract(EstadoContractDto dto);

    PageResponse<EstadoContractDto> getAllEstadoContracts(int pageNo, int pageSize);

    EstadoContractDto getEstadoContractById(int id);

    EstadoContractDto updateEstadoContract(EstadoContractDto dto, int id);

    void deleteEstadoContract(int id);
}