package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.piscinadto.PiscinaDto;

public interface PiscinaService {

    PiscinaDto createPiscina(PiscinaDto dto);

    PageResponse<PiscinaDto> getAllPiscinas(int pageNo, int pageSize);

    PiscinaDto getPiscinaById(int id);

    PiscinaDto updatePiscina(PiscinaDto dto, int id);

    void deletePiscina(int id);
}