package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.tipoquartodto.TipoQuartoDto;

public interface TipoQuartoService {

    TipoQuartoDto createTipoQuarto(TipoQuartoDto dto);

    PageResponse<TipoQuartoDto> getAllTipoQuarto(int pageNo, int pageSize);

    TipoQuartoDto getTipoQuartoById(int id);

    TipoQuartoDto updateTipoQuarto(TipoQuartoDto dto, int id);

    void deleteTipoQuarto(int id);
}