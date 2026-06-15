package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.quartodto.QuartoDto;

public interface QuartoService {

    QuartoDto createQuarto(QuartoDto dto);

    PageResponse<QuartoDto> getAllQuartos(int pageNo, int pageSize);

    QuartoDto getQuartoById(int id);

    QuartoDto updateQuarto(QuartoDto dto, int id);

    void deleteQuarto(int id);
}