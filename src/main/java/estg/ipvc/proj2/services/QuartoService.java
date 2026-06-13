package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.quartodto.QuartoDto;

public interface QuartoService {

    QuartoDto createQuarto(QuartoDto dto);

    PageResponse<QuartoDto> getAllQuartos(int pageNo, int pageSize);

    QuartoDto getQuartoById(int id);

    QuartoDto updateQuarto(QuartoDto dto, int id);

    void deleteQuarto(int id);
}