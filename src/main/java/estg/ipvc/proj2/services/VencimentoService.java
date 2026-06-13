package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.vencimentodto.VencimentoDto;

public interface VencimentoService {

    VencimentoDto createVencimento(VencimentoDto dto);

    PageResponse<VencimentoDto> getAllVencimentos(int pageNo, int pageSize);

    VencimentoDto getVencimentoById(int id);

    VencimentoDto updateVencimento(VencimentoDto dto, int id);

    void deleteVencimento(int id);
}