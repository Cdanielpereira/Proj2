package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.tipoquartodto.TipoQuartoDto;

public interface TipoQuartoService {

    TipoQuartoDto createTipoQuarto(TipoQuartoDto dto);

    PageResponse<TipoQuartoDto> getAllTipoQuarto(int pageNo, int pageSize);

    TipoQuartoDto getTipoQuartoById(int id);

    TipoQuartoDto updateTipoQuarto(TipoQuartoDto dto, int id);

    void deleteTipoQuarto(int id);
}