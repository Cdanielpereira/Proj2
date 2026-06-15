package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.marcacaodto.MarcacaoDto;

public interface MarcacaoService {

    MarcacaoDto createMarcacao(MarcacaoDto dto);

    PageResponse<MarcacaoDto> getAllMarcacoes(int pageNo, int pageSize);

    MarcacaoDto getMarcacaoById(int id);

    MarcacaoDto updateMarcacao(MarcacaoDto dto, int id);

    void deleteMarcacao(int id);
}