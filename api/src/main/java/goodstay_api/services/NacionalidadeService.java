package goodstay_api.services;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.nacionalidadedto.NacionalidadeDto;

public interface NacionalidadeService {

    NacionalidadeDto createNacionalidade(NacionalidadeDto dto);

    PageResponse<NacionalidadeDto> getAllNacionalidades(int pageNo, int pageSize);

    NacionalidadeDto getNacionalidadeById(int id);

    NacionalidadeDto updateNacionalidade(NacionalidadeDto dto, int id);

    void deleteNacionalidade(int id);
}