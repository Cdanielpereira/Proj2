package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.tipoIVAdto.TipoIVADto;

public interface TipoIVAService {

    TipoIVADto createTipoIVA(TipoIVADto dto);

    PageResponse<TipoIVADto> getAllTipoIVA(int pageNo, int pageSize);

    TipoIVADto getTipoIVAById(int id);

    TipoIVADto updateTipoIVA(TipoIVADto dto, int id);

    void deleteTipoIVA(int id);
}