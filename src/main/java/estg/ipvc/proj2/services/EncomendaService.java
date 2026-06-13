package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.encomendadto.EncomendaDto;

public interface EncomendaService {

    EncomendaDto createEncomenda(EncomendaDto dto);

    PageResponse<EncomendaDto> getAllEncomendas(int pageNo, int pageSize);

    EncomendaDto getEncomendaById(int id);

    EncomendaDto updateEncomenda(EncomendaDto dto, int id);

    void deleteEncomenda(int id);
}