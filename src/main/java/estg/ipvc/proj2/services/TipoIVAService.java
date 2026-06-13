package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.tipoIVAdto.TipoIVADto;

public interface TipoIVAService {

    TipoIVADto createTipoIVA(TipoIVADto dto);

    PageResponse<TipoIVADto> getAllTipoIVA(int pageNo, int pageSize);

    TipoIVADto getTipoIVAById(int id);

    TipoIVADto updateTipoIVA(TipoIVADto dto, int id);

    void deleteTipoIVA(int id);
}