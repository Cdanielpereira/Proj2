package goodstay_api.services;

import goodstay_api.dtos.colaboradordto.ColaboradorDto;
import goodstay_api.dtos.common.PageResponse;

public interface ColaboradorService {

    ColaboradorDto createColaborador(ColaboradorDto colaboradorDto);

    PageResponse<ColaboradorDto> getAllColaboradores(int pageNo, int pageSize);

    ColaboradorDto getColaboradorById(int id);

    ColaboradorDto updateColaborador(ColaboradorDto colaboradorDto, int id);

    void deleteColaboradorId(int id);
}