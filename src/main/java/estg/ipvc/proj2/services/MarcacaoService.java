package estg.ipvc.proj2.services;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.marcacaodto.MarcacaoDto;

public interface MarcacaoService {

    MarcacaoDto createMarcacao(MarcacaoDto dto);

    PageResponse<MarcacaoDto> getAllMarcacoes(int pageNo, int pageSize);

    MarcacaoDto getMarcacaoById(int id);

    MarcacaoDto updateMarcacao(MarcacaoDto dto, int id);

    void deleteMarcacao(int id);
}