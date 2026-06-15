package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.faturarecibodto.FaturaReciboDto;

public interface FaturaReciboService {

    FaturaReciboDto createFaturaRecibo(FaturaReciboDto dto);

    PageResponse<FaturaReciboDto> getAllFaturaRecibos(int pageNo, int pageSize);

    FaturaReciboDto getFaturaReciboById(int id);

    FaturaReciboDto updateFaturaRecibo(FaturaReciboDto dto, int id);

    void deleteFaturaRecibo(int id);
}