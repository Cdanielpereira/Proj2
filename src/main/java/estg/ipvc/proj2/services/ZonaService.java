package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.zonadto.ZonaDto;

public interface ZonaService {

    ZonaDto createZona(ZonaDto dto);

    PageResponse<ZonaDto> getAllZonas(int pageNo, int pageSize);

    ZonaDto getZonaById(int id);

    ZonaDto updateZona(ZonaDto dto, int id);

    void deleteZona(int id);
}