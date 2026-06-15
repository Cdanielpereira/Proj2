package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.zonadto.ZonaDto;

public interface ZonaService {

    ZonaDto createZona(ZonaDto dto);

    PageResponse<ZonaDto> getAllZonas(int pageNo, int pageSize);

    ZonaDto getZonaById(int id);

    ZonaDto updateZona(ZonaDto dto, int id);

    void deleteZona(int id);
}