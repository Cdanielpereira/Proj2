package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.servicodto.ServicoDto;

public interface ServicoService {

    ServicoDto createServico(ServicoDto dto);

    PageResponse<ServicoDto> getAllServicos(int pageNo, int pageSize);

    ServicoDto getServicoById(int id);

    ServicoDto updateServico(ServicoDto dto, int id);

    void deleteServico(int id);
}