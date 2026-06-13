package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.estadomarcacaodto.EstadoMarcacaoDto;

public interface EstadoMarcacaoService {

    EstadoMarcacaoDto createEstadoMarcacao(EstadoMarcacaoDto dto);

    PageResponse<EstadoMarcacaoDto> getAllEstadoMarcacoes(int pageNo, int pageSize);

    EstadoMarcacaoDto getEstadoMarcacaoById(int id);

    EstadoMarcacaoDto updateEstadoMarcacao(EstadoMarcacaoDto dto, int id);

    void deleteEstadoMarcacao(int id);
}