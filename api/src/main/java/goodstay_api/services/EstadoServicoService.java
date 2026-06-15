package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.estadoservicodto.EstadoServicoDto;

public interface EstadoServicoService {

    EstadoServicoDto createEstadoServico(EstadoServicoDto dto);

    PageResponse<EstadoServicoDto> getAllEstadoServicos(int pageNo, int pageSize);

    EstadoServicoDto getEstadoServicoById(int id);

    EstadoServicoDto updateEstadoServico(EstadoServicoDto dto, int id);

    void deleteEstadoServico(int id);
}