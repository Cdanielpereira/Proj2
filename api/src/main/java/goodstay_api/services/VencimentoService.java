package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.vencimentodto.VencimentoDto;

public interface VencimentoService {

    VencimentoDto createVencimento(VencimentoDto dto);

    PageResponse<VencimentoDto> getAllVencimentos(int pageNo, int pageSize);

    VencimentoDto getVencimentoById(int id);

    VencimentoDto updateVencimento(VencimentoDto dto, int id);

    void deleteVencimento(int id);
}