package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.limpezadto.LimpezaDto;

public interface LimpezaService {

    LimpezaDto createLimpeza(LimpezaDto limpezaDto);

    PageResponse<LimpezaDto> getAllLimpezas(int pageNo, int pageSize);

    LimpezaDto getLimpezaById(Integer idZona, Integer idFunc);

    LimpezaDto updateLimpeza(LimpezaDto limpezaDto, Integer idZona, Integer idFunc);

    void deleteLimpeza(Integer idZona, Integer idFunc);
}