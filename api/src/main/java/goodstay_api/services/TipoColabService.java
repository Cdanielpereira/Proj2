package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.tipocolabdto.TipoColabDto;

public interface TipoColabService {

    TipoColabDto createTipoColab(TipoColabDto dto);

    PageResponse<TipoColabDto> getAllTipoColab(int pageNo, int pageSize);

    TipoColabDto getTipoColabById(int id);

    TipoColabDto updateTipoColab(TipoColabDto dto, int id);

    void deleteTipoColab(int id);
}