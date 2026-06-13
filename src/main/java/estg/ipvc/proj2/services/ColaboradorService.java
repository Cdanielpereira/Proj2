package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.colaboradordto.ColaboradorDto;
import estg.ipvc.proj2.dtos.common.PageResponse;

public interface ColaboradorService {

    ColaboradorDto createColaborador(ColaboradorDto colaboradorDto);

    PageResponse<ColaboradorDto> getAllColaboradores(int pageNo, int pageSize);

    ColaboradorDto getColaboradorById(int id);

    ColaboradorDto updateColaborador(ColaboradorDto colaboradorDto, int id);

    void deleteColaboradorId(int id);
}