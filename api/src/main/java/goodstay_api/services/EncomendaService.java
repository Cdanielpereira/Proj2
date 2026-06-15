package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.encomendadto.EncomendaDto;

public interface EncomendaService {

    EncomendaDto createEncomenda(EncomendaDto dto);

    PageResponse<EncomendaDto> getAllEncomendas(int pageNo, int pageSize);

    EncomendaDto getEncomendaById(int id);

    EncomendaDto updateEncomenda(EncomendaDto dto, int id);

    void deleteEncomenda(int id);
}