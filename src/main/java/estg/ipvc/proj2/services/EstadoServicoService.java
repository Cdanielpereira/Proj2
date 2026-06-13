package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.estadoservicodto.EstadoServicoDto;

public interface EstadoServicoService {

    EstadoServicoDto createEstadoServico(EstadoServicoDto dto);

    PageResponse<EstadoServicoDto> getAllEstadoServicos(int pageNo, int pageSize);

    EstadoServicoDto getEstadoServicoById(int id);

    EstadoServicoDto updateEstadoServico(EstadoServicoDto dto, int id);

    void deleteEstadoServico(int id);
}