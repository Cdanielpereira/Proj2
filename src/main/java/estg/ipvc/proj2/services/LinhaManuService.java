package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.linhamanudto.LinhaManuDto;

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