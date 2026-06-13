package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.servicodto.ServicoDto;

public interface ServicoService {

    ServicoDto createServico(ServicoDto dto);

    PageResponse<ServicoDto> getAllServicos(int pageNo, int pageSize);

    ServicoDto getServicoById(int id);

    ServicoDto updateServico(ServicoDto dto, int id);

    void deleteServico(int id);
}