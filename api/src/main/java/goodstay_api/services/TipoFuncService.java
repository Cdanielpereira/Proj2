package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.tipofuncdto.TipoFuncDto;

public interface TipoFuncService {

    TipoFuncDto createTipoFunc(TipoFuncDto dto);

    PageResponse<TipoFuncDto> getAllTipoFunc(int pageNo, int pageSize);

    TipoFuncDto getTipoFuncById(int id);

    TipoFuncDto updateTipoFunc(TipoFuncDto dto, int id);

    void deleteTipoFunc(int id);
}