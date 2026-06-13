package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.manutencaodto.ManutencaoDto;

public interface ManutencaoService {

    ManutencaoDto createManutencao(ManutencaoDto dto);

    PageResponse<ManutencaoDto> getAllManutencao(int pageNo, int pageSize);

    ManutencaoDto getManutencaoById(int id);

    ManutencaoDto updateManutencao(ManutencaoDto dto, int id);

    void deleteManutencao(int id);
}