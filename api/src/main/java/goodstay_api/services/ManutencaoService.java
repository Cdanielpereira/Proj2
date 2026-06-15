package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.manutencaodto.ManutencaoDto;

public interface ManutencaoService {

    ManutencaoDto createManutencao(ManutencaoDto dto);

    PageResponse<ManutencaoDto> getAllManutencao(int pageNo, int pageSize);

    ManutencaoDto getManutencaoById(int id);

    ManutencaoDto updateManutencao(ManutencaoDto dto, int id);

    void deleteManutencao(int id);
}