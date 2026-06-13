package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.limpezadto.LimpezaDto;

public interface LimpezaService {

    LimpezaDto createLimpeza(LimpezaDto limpezaDto);

    PageResponse<LimpezaDto> getAllLimpezas(int pageNo, int pageSize);

    LimpezaDto getLimpezaById(Integer idZona, Integer idFunc);

    LimpezaDto updateLimpeza(LimpezaDto limpezaDto, Integer idZona, Integer idFunc);

    void deleteLimpeza(Integer idZona, Integer idFunc);
}