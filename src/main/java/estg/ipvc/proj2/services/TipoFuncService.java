package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.tipofuncdto.TipoFuncDto;

public interface TipoFuncService {

    TipoFuncDto createTipoFunc(TipoFuncDto dto);

    PageResponse<TipoFuncDto> getAllTipoFunc(int pageNo, int pageSize);

    TipoFuncDto getTipoFuncById(int id);

    TipoFuncDto updateTipoFunc(TipoFuncDto dto, int id);

    void deleteTipoFunc(int id);
}