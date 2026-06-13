package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.tipocolabdto.TipoColabDto;

public interface TipoColabService {

    TipoColabDto createTipoColab(TipoColabDto dto);

    PageResponse<TipoColabDto> getAllTipoColab(int pageNo, int pageSize);

    TipoColabDto getTipoColabById(int id);

    TipoColabDto updateTipoColab(TipoColabDto dto, int id);

    void deleteTipoColab(int id);
}