package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.piscinadto.PiscinaDto;

public interface PiscinaService {

    PiscinaDto createPiscina(PiscinaDto dto);

    PageResponse<PiscinaDto> getAllPiscinas(int pageNo, int pageSize);

    PiscinaDto getPiscinaById(int id);

    PiscinaDto updatePiscina(PiscinaDto dto, int id);

    void deletePiscina(int id);
}