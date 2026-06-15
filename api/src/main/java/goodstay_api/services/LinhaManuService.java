package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.linhamanudto.LinhaManuDto;

public interface LinhaManuService {

    LinhaManuDto createLinhaManu(LinhaManuDto dto);

    PageResponse<LinhaManuDto> getAllLinhaManu(int pageNo, int pageSize);

    LinhaManuDto getLinhaManuById(Integer idManu, Integer idServico);

    LinhaManuDto updateLinhaManu(
            LinhaManuDto dto,
            Integer idManu,
            Integer idServico
    );

    void deleteLinhaManu(
            Integer idManu,
            Integer idServico
    );
}