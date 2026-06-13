package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.tipozonadto.TipoZonaDto;

public interface TipoZonaService {

    TipoZonaDto createTipoZona(TipoZonaDto dto);

    PageResponse<TipoZonaDto> getAllTipoZona(int pageNo, int pageSize);

    TipoZonaDto getTipoZonaById(int id);

    TipoZonaDto updateTipoZona(TipoZonaDto dto, int id);

    void deleteTipoZona(int id);
}