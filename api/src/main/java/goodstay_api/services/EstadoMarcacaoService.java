package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.estadomarcacaodto.EstadoMarcacaoDto;

public interface EstadoMarcacaoService {

    EstadoMarcacaoDto createEstadoMarcacao(EstadoMarcacaoDto dto);

    PageResponse<EstadoMarcacaoDto> getAllEstadoMarcacoes(int pageNo, int pageSize);

    EstadoMarcacaoDto getEstadoMarcacaoById(int id);

    EstadoMarcacaoDto updateEstadoMarcacao(EstadoMarcacaoDto dto, int id);

    void deleteEstadoMarcacao(int id);
}