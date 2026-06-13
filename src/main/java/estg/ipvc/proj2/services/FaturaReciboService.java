package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.faturarecibodto.FaturaReciboDto;

public interface FaturaReciboService {

    FaturaReciboDto createFaturaRecibo(FaturaReciboDto dto);

    PageResponse<FaturaReciboDto> getAllFaturaRecibos(int pageNo, int pageSize);

    FaturaReciboDto getFaturaReciboById(int id);

    FaturaReciboDto updateFaturaRecibo(FaturaReciboDto dto, int id);

    void deleteFaturaRecibo(int id);
}