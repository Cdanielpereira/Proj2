package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.tipozonadto.TipoZonaDto;

public interface TipoZonaService {

    TipoZonaDto createTipoZona(TipoZonaDto dto);

    PageResponse<TipoZonaDto> getAllTipoZona(int pageNo, int pageSize);

    TipoZonaDto getTipoZonaById(int id);

    TipoZonaDto updateTipoZona(TipoZonaDto dto, int id);

    void deleteTipoZona(int id);
}